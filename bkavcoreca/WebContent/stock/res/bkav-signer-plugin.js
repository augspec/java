// BkavCoreCA Interface
var BkavCoreCA = {
	SignXML : function(dataInput, objectCert, functionCallback) {
		if (iCheckPlatform == 3) // iOS
		{
			var callInfo = {};
			callInfo.functionname = "SignXML";
			callInfo.functioncallback = functionCallback.name;
			var args = [ dataInput ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		} else if (iCheckPlatform == 2) {
			signAndroid(dataInput, objectCert, DocumentType.XML,
					functionCallback);
		} else {

		}
	},
	VerifyXML : function(dataInput, functionCallback) {
		if (iCheckPlatform == 3) // iOS
		{
			var callInfo = {};
			callInfo.functionname = "VerifyXML";
			callInfo.functioncallback = functionCallback.name;
			var args = [ dataInput ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		} else if (iCheckPlatform == 2) {
			verifyAndroid(dataInput, DocumentType.XML, functionCallback);
		}
	},
	SignOOXML : function(dataInput, objectCert, functionCallback) {
		if (iCheckPlatform == 3) // iOS
		{
			var callInfo = {};
			callInfo.functionname = "SignOOXML";
			callInfo.functioncallback = functionCallback.name;
			var args = [ dataInput ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		} else if (iCheckPlatform == 2) {
			signAndroid(dataInput, objectCert, DocumentType.OFFICE,
					functionCallback);
		}
	},
	VerifyOOXML : function(dataInput, functionCallback) {
		if (iCheckPlatform == 3) // iOS
		{
			var callInfo = {};
			callInfo.functionname = "VerifyOOXML";
			callInfo.functioncallback = functionCallback.name;
			var args = [ dataInput ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		} else if (iCheckPlatform == 2) {
			verifyAndroid(dataInput, DocumentType.OFFICE, functionCallback);
		}
	},
	SignCMS : function(dataInput, objectCert, functionCallback) {
		if (iCheckPlatform == 3) // iOS
		{
			var callInfo = {};
			callInfo.functionname = "SignCMS";
			callInfo.functioncallback = functionCallback.name;
			var args = [ dataInput ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		} else if (iCheckPlatform == 2) {
			signAndroid(dataInput, objectCert, DocumentType.CMS,
					functionCallback);
		}
	},
	VerifyCMS : function(dataInput, functionCallback) {
		if (iCheckPlatform == 3) // iOS
		{
			var callInfo = {};
			callInfo.functionname = "VerifyCMS";
			callInfo.functioncallback = functionCallback.name;
			var args = [ dataInput ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		} else if (iCheckPlatform == 2) {
			verifyAndroid(dataInput, DocumentType.CMS, functionCallback);
		}
	},
	SignPDF : function(dataInput, objectCert, functionCallback) {
		if (iCheckPlatform == 3) // iOS
		{
			var callInfo = {};
			callInfo.functionname = "SignPDF";
			callInfo.functioncallback = functionCallback.name;
			var args = [ dataInput ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		} else if (iCheckPlatform == 2)// Android
		{
			signAndroid(dataInput, objectCert, DocumentType.PDF,
					functionCallback);
		} else {// Desktop
			signDesktop(dataInput, objectCert, DocumentType.PDF,
					functionCallback);
		}
	},
	VerifyPDF : function(dataInput, objectCert, functionCallback) {
		if (iCheckPlatform == 3) // iOS
		{
			var callInfo = {};
			callInfo.functionname = "VerifyPDF";
			callInfo.functioncallback = functionCallback.name;
			var args = [ dataInput ];
			callInfo.args = args;
			return SendToChrome(callInfo);
		} else if (iCheckPlatform == 2) {
			verifyAndroid(dataInput, DocumentType.PDF, functionCallback);
		}
	},
	GetCertListByFilter : function(functionCallback) {
		if (iCheckPlatform == 3) // iOS
		{
			var callInfo = {};
			callInfo.functionname = "GetCertListByFilter";
			callInfo.functioncallback = functionCallback.name;
			var args = [];
			callInfo.args = args;
			return SendToChrome(callInfo);
		} else {
			// Have not supported yet!
		}
	}
}

// ios
function createIFrame(src) {
	var rootElm = document.documentElement;
	var newFrameElm = document.createElement("IFRAME");
	newFrameElm.setAttribute("src", src);
	rootElm.appendChild(newFrameElm);
	return newFrameElm;
}

function SendToChrome(dataToChrome) {
	var url = "js-command:";
	url += JSON.stringify(dataToChrome)
	var iFrame = createIFrame(url);
	// remove the frame now
	iFrame.parentNode.removeChild(iFrame);
}

function getMobileOperatingSystem() {
	var userAgent = navigator.userAgent || navigator.vendor || window.opera;
	// Windows Phone must come first because its UA also contains "Android"
	if (/windows phone/i.test(userAgent)) {
		// return "Windows Phone";
		return 1;
	}
	if (/android/i.test(userAgent)) {
		// return "Android";
		return 2;
	}
	// iOS detection from: http://stackoverflow.com/a/9039885/177710
	if (/iPad|iPhone|iPod/.test(userAgent) && !window.MSStream) {
		// return "iOS";
		return 3;
	}
	return 4; // unknown
}
var iCheckPlatform = getMobileOperatingSystem();

/**
 * Convert from base64 string to buffer view
 * 
 * @param {String|Object}
 *            buf: Base64 string input data
 * @returns {byte[]}
 */
function convertStringToArrayBufferView(str) {
	var bytes = new Uint8Array(str.length);
	for (var iii = 0; iii < str.length; iii++) {
		bytes[iii] = str.charCodeAt(iii);
	}

	return bytes;
}

/**
 * Convert from buffer view (return from bkavcrypto) to base64 string
 * 
 * @param {byte[]|Object}
 *            buf: Bytes array from buffer view
 * @returns {String}
 */
function arrayBufferToString(array) {
	var out, i, len, c;
	var char2, char3;

	out = "";
	len = array.length;
	i = 0;
	while (i < len) {
		c = array[i++];
		switch (c >> 4) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
			// 0xxxxxxx
			out += String.fromCharCode(c);
			break;
		case 12:
		case 13:
			// 110x xxxx 10xx xxxx
			char2 = array[i++];
			out += String.fromCharCode(((c & 0x1F) << 6) | (char2 & 0x3F));
			break;
		case 14:
			// 1110 xxxx 10xx xxxx 10xx xxxx
			char2 = array[i++];
			char3 = array[i++];
			out += String.fromCharCode(((c & 0x0F) << 12)
					| ((char2 & 0x3F) << 6) | ((char3 & 0x3F) << 0));
			break;
		}
	}

	return out;
}

// Object ...
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
 * @param {String}
 *            dataInput: Base64String input data to sign.
 * @param {ObjCertificate}
 *            objectCert: Object contain pkcs#11 user PIN.
 * @param {String}
 *            docType: Document type (XML, PDF, OFFICE, CMS).
 * @param {Object}
 *            callback: Function callback when sign complete.
 * @return {void}
 */
function signAndroid(dataInput, objectCert, docType, callback) {
	if (iCheckPlatform != 2) {
		return;
	}
	var dataToSign = convertStringToArrayBufferView(dataInput);
	var pinToSign = convertStringToArrayBufferView(objectCert.PIN);

	var signedBytes;
	alert(bkavcrypto == null)
	switch (docType) {
	case DocumentType.XML: {
		signedBytes = bkavcrypto.signXML(dataToSign, pinToSign);
		break;
	}
	case DocumentType.PDF: {
		signedBytes = bkavcrypto.signPDF(dataToSign, pinToSign);
		break;
	}
	case DocumentType.OFFICE: {
		signedBytes = bkavcrypto.signOffice(dataToSign, pinToSign);
		break;
	}
	case DocumentType.CMS: {
		signedBytes = bkavcrypto.signCMS(dataToSign, pinToSign);
		break;
	}
	default: {
		signedBytes = null;
	}
	}

	// When sign complete
	signedBytes.then(
			function(result_signature) {
				var signedBase64 = arrayBufferToString(new Uint8Array(
						result_signature));
				console.log(signedBase64);
				callback(signedBase64);
			}, function(e) {
				console.log("Error: " + e);
			});
}

/**
 * Android verify method
 * 
 * @param {String}
 *            dataInput: Base64String input data to verify.
 * @param {String}
 *            docType: Document type (XML, PDF, OFFICE, CMS).
 * @param {Object}
 *            callback: Function callback when verify complete.
 * @return {void}
 */
function verifyAndroid(dataInput, docType, callback) {
	if (iCheckPlatform != 2) {
		return;
	}
	var dataToVerify = convertStringToArrayBufferView(dataInput);

	var verifiedBytes;
	switch (docType) {
	case DocumentType.XML: {
		verifiedBytes = bkavcrypto.verifyXML(dataToVerify);
		break;
	}
	case DocumentType.PDF: {
		verifiedBytes = bkavcrypto.verifyPDF(dataToVerify);
		break;
	}
	case DocumentType.OFFICE: {
		verifiedBytes = bkavcrypto.verifyOffice(dataToVerify);
		break;
	}
	case DocumentType.CMS: {
		verifiedBytes = bkavcrypto.verifyCMS(dataToVerify);
		break;
	}
	default: {
		verifiedBytes = null;
	}
	}

	// When verify complete
	verifiedBytes.then(function(_result) {
		var verifiedBase64 = arrayBufferToString(_result);
		callback(verifiedBase64);
	}, function(e) {
		console.log("Error: " + e);
	});
}

function signDesktop(dataInput, objectCert, docType, functionCallback) {
	userPinInput();
	functionCallback("Desktop signature: Not yet supported");
}


function userPinInput(){
	var icon = "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";
	if(!$('#user_pin_modal').length){
		$('body').append("<div id='user_pin_modal' class='bkav-modal' style='display: block;'><div class='bkav-modal-content'><div class='bkav-modal-header'><span class='bkav-close'>×</span></div><div class='bkav-modal-body'><table><tr><td><img alt=''src='data:image/png;base64," + icon + "'></td><td><label>Require Pkcs#11 user's PIN</label></td></tr><tr><td class='middle'><span>User PIN:</span></td><td><input type='password' id='user_pin'></td></tr><tr><td></td><td><button id='user_pin_ok' class='bkav-primary'>OK</button><button class='bkav-close bkav-default'>Cancel</button></td></tr></table></div></div></div>");
	}
	// Get the modal
	var modal = document.getElementById('user_pin_modal');
	
	var pinField = $('#user_pin');
	pinField.text('');
	modal.style.display = "block";

	// Get the <span> element that closes the modal
	var closeSpan = document.getElementsByClassName("bkav-close")[0];
	var cancelSpan = document.getElementsByClassName("bkav-close")[1];


	// When the user clicks on <span> (x), close the modal
	closeSpan.onclick = function() {
	    modal.style.display = "none";
	}
	cancelSpan.onclick = function() {
	    modal.style.display = "none";
	}
	
	var okBtn = document.getElementById("user_pin_ok");
	okBtn.onclick = function(){
		modal.style.display = "none";
		//Sign here
	}
}
