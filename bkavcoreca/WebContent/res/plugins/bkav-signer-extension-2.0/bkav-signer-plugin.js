// ios
function createIFrame(src)
{
    var rootElm = document.documentElement;
    var newFrameElm = document.createElement("IFRAME");
    newFrameElm.setAttribute("src",src);
    rootElm.appendChild(newFrameElm);
    return newFrameElm;
}

function SendToChrome(dataToChrome) {
	var url = "js-command:";
    url += JSON.stringify(dataToChrome)
    var iFrame = createIFrame(url);
    //remove the frame now
    iFrame.parentNode.removeChild(iFrame);
}

function getMobileOperatingSystem() {
  var userAgent = navigator.userAgent || navigator.vendor || window.opera;
      // Windows Phone must come first because its UA also contains "Android"
    if (/windows phone/i.test(userAgent)) {
        //return "Windows Phone";
		return 1;
    }
    if (/android/i.test(userAgent)) {
        //return "Android";
		return 2;		
    }
    // iOS detection from: http://stackoverflow.com/a/9039885/177710
    if (/iPad|iPhone|iPod/.test(userAgent) && !window.MSStream) {
        //return "iOS";
		return 3;
    }
    return 4; // unknown
}
var iCheckPlatform = getMobileOperatingSystem();

/**
 * Convert from base64 string to buffer view
 * @param {String|Object} buf: Base64 string input data
 * @returns {byte[]} 
 */
function convertStringToArrayBufferView(str)
{
    var bytes = new Uint8Array(str.length);
    for (var iii = 0; iii < str.length; iii++) 
    {
        bytes[iii] = str.charCodeAt(iii);
    }

    return bytes;
} 

/**
 * Convert from buffer view (return from bkavcrypto) to base64 string
 *
 * @param {byte[]|Object} buf: Bytes array from buffer view
 * @returns {String} 
 */
function arrayBufferToString(array) {
    var out, i, len, c;
    var char2, char3;

    out = "";
    len = array.length;
    i = 0;
    while(i < len) {
	c = array[i++];
	switch(c >> 4)
	{ 
	  case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7:
	    // 0xxxxxxx
	    out += String.fromCharCode(c);
	    break;
	  case 12: case 13:
	    // 110x xxxx   10xx xxxx
	    char2 = array[i++];
	    out += String.fromCharCode(((c & 0x1F) << 6) | (char2 & 0x3F));
	    break;
	  case 14:
	    // 1110 xxxx  10xx xxxx  10xx xxxx
        char2 = array[i++];
	    char3 = array[i++];
	    out += String.fromCharCode(((c & 0x0F) << 12) |
					   ((char2 & 0x3F) << 6) |
					   ((char3 & 0x3F) << 0));
	    break;
	}
    }

    return out;
}

//Object ...
function ObjCertificate() {
    this.CertificateBase64 = "";
    this.CertificateSerialNumber = "";
    this.OcspUrl = "";
	this.PIN = "";
}

/**
 * Object document type
 */
var DocumentType = {
	XML : "XML",
	PDF : "PDF",
	OFFICE : "OFFICE",
	CMS : "CMS",
}

/**
 * Android sign method
 *
 * @param {String} dataInput: Base64String input data to sign.
 * @param {ObjCertificate} objectCert: Object contain pkcs#11 user PIN.
 * @param {String} docType: Document type (XML, PDF, OFFICE, CMS).
 * @param {Object} callback: Function callback when sign complete.
 * @return {void}
 */
function signAndroid(dataInput, objectCert, docType, callback){
	if(iCheckPlatform != 2){
		return;
	}
	var dataToSign = convertStringToArrayBufferView(dataInput);
	var pinToSign = convertStringToArrayBufferView(objectCert.PIN);
	var para = convertStringToArrayBufferView("");
	
	var signedBytes;
	switch(docType){
		case DocumentType.XML:{
			console.log(dataToSign);
			console.log(pinToSign);
			signedBytes = bkavcrypto.signXML(dataToSign, pinToSign, para);
			break;
		}
		case DocumentType.PDF:{
			signedBytes = bkavcrypto.signPDF(dataToSign, pinToSign, para);
			break;
		}
		case DocumentType.OFFICE:{
			signedBytes = bkavcrypto.signOffice(dataToSign, pinToSign, para);
			break;
		}
		case DocumentType.CMS:{
			signedBytes = bkavcrypto.signCMS(dataToSign, pinToSign, para);
			break;
		}
		default: {
			signedBytes = null;
		}
	}
	
	//When sign complete
	signedBytes.then(
		function(result_signature){
			var signedBase64 = arrayBufferToString(new Uint8Array(result_signature));
			console.log(signedBase64);
			callback(signedBase64);
		}, 
		function(e){
			console.log("Error: " + e);
		}
	);
}

/**
 * Android verify method
 *
 * @param {String} dataInput: Base64String input data to verify.
 * @param {String} docType: Document type (XML, PDF, OFFICE, CMS).
 * @param {Object} callback: Function callback when verify complete.
 * @return {void}
 */
function verifyAndroid(dataInput, docType, callback){
	if(iCheckPlatform != 2){
		return;
	}
	var dataToVerify = convertStringToArrayBufferView(dataInput);
	
	var verifiedBytes;
	switch(docType){
		case DocumentType.XML:{
			verifiedBytes = bkavcrypto.verifyXML(dataToVerify);
			break;
		}
		case DocumentType.PDF:{
			verifiedBytes = bkavcrypto.verifyPDF(dataToVerify);
			break;
		}
		case DocumentType.OFFICE:{
			verifiedBytes = bkavcrypto.verifyOffice(dataToVerify);
			break;
		}
		case DocumentType.CMS:{
			verifiedBytes = bkavcrypto.verifyCMS(dataToVerify);
			break;
		}
		default: {
			verifiedBytes = null;
		}
	}
	
	//When verify complete
	verifiedBytes.then(
		function(_result){
			var verifiedBase64 = arrayBufferToString(_result);
			callback(verifiedBase64);
		}, 
		function(e){
			console.log("Error: " + e);
		}
	);
}

// interface
var BkavBChromeCA = {
    SignXML: function (dataInput, objectCert, functionCallback) {
		if (iCheckPlatform == 3) //iOS
		{			
			var callInfo = {};
			callInfo.functionname = "SignXML";
			callInfo.functioncallback = functionCallback.name;
			var args = [
						  dataInput
					   ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		}
        else
		{
			signAndroid(dataInput, objectCert, DocumentType.XML, functionCallback);
		}
    },
	VerifyXML: function (dataInput, functionCallback) {
        if (iCheckPlatform == 3) //iOS
		{		
			var callInfo = {};
			callInfo.functionname = "VerifyXML";
			callInfo.functioncallback = functionCallback.name;
			var args = [
						  dataInput
					   ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		}
        else
		{
			verifyAndroid(dataInput, DocumentType.XML, functionCallback);	
		}
    },
	SignOOXML: function (dataInput, objectCert, functionCallback) {
        if (iCheckPlatform == 3) //iOS
		{			
			var callInfo = {};
			callInfo.functionname = "SignOOXML";
			callInfo.functioncallback = functionCallback.name;
			var args = [
						  dataInput
					   ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		}
        else
		{
			signAndroid(dataInput, objectCert, DocumentType.OFFICE, functionCallback);
		}
    },
	VerifyOOXML: function (dataInput, functionCallback) {
       if (iCheckPlatform == 3) //iOS
		{			
			var callInfo = {};
			callInfo.functionname = "VerifyOOXML";
			callInfo.functioncallback = functionCallback.name;
			var args = [
						  dataInput
					   ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		}
        else
		{
			verifyAndroid(dataInput, DocumentType.OFFICE, functionCallback);	
		}
    },
	SignCMS: function (dataInput, objectCert, functionCallback) {
        if (iCheckPlatform == 3) //iOS
		{			
			var callInfo = {};
			callInfo.functionname = "SignCMS";
			callInfo.functioncallback = functionCallback.name;
			var args = [
						  dataInput
					   ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		}
        else
		{
			signAndroid(dataInput, objectCert, DocumentType.CMS, functionCallback);
		}
    },
	VerifyCMS: function (dataInput, functionCallback) {
        if (iCheckPlatform == 3) //iOS
		{			
			var callInfo = {};
			callInfo.functionname = "VerifyCMS";
			callInfo.functioncallback = functionCallback.name;
			var args = [
						  dataInput
					   ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		}
        else
		{
			verifyAndroid(dataInput, DocumentType.CMS, functionCallback);	
		}
    },
	SignPDF: function (dataInput, objectCert, functionCallback) {
       if (iCheckPlatform == 3) //iOS
		{			
			var callInfo = {};
			callInfo.functionname = "SignPDF";
			callInfo.functioncallback = functionCallback.name;
			var args = [
						  dataInput
					   ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		}
        else
		{
			signAndroid(dataInput, objectCert, DocumentType.PDF, functionCallback);
		}
    },
	VerifyPDF: function (dataInput, objectCert, functionCallback) {
       if (iCheckPlatform == 3) //iOS
		{			
			var callInfo = {};
			callInfo.functionname = "VerifyPDF";
			callInfo.functioncallback = functionCallback.name;
			var args = [
						  dataInput
					   ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		}
        else
		{
			verifyAndroid(dataInput, DocumentType.PDF, functionCallback);	
		}
    },
	GetCertListByFilter: function (functionCallback) {
        if (iCheckPlatform == 3) //iOS
		{		
			var callInfo = {};
			callInfo.functionname = "GetCertListByFilter";
			callInfo.functioncallback = functionCallback.name;
			var args = [];
			callInfo.args = args;
			return SendToChrome(callInfo);		
		}
        else
		{
			// Have not supported yet!
		}
    }
}