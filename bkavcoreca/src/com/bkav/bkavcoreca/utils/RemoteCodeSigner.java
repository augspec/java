package com.bkav.bkavcoreca.utils;

import java.io.IOException;
import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.signserver.clientws.ClientWS;
import org.signserver.clientws.ClientWSProxy;
import org.signserver.clientws.DataResponse;
import org.signserver.clientws.InternalServerException;
import org.signserver.clientws.RequestFailedException;
import org.signserver.clientws.SignData;
import org.signserver.clientws.ValidationDataResponse;

import com.bkav.bkavsignature.utils.BkavSignaturesException;

public class RemoteCodeSigner implements ICodeSigner {
	private static final Logger LOG = Logger.getLogger(RemoteCodeSigner.class);

	@Override
	public byte[] signJar(byte[] data) throws BkavSignaturesException {
		String workerName = null;
		try {
			workerName = GlobalConfig.getProperty(GlobalConfig.JAR_SIGNER);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sign(data, workerName);
	}

	@Override
	public byte[] signExe(byte[] data) throws BkavSignaturesException {
		String workerName = null;
		try {
			workerName = GlobalConfig.getProperty(GlobalConfig.EXE_SIGNER);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sign(data, workerName);
	}

	public byte[] sign(byte[] unsignData, String workerName) {
		try {
			SSLHandler ssl = new SSLHandler();
			ssl.setSSL();
			
			ClientWSProxy proxy = new ClientWSProxy(GlobalConfig.getProperty(GlobalConfig.SIGNSERVER_ENPOINT));
			ClientWS clientWS = proxy.getClientWS();
			SignData data = new SignData();
			data.setDataToSign(unsignData);
			data.setWorkerName(workerName);			
			DataResponse response = clientWS.sign(data);
			byte[] data2 = response.getData();
			return data2;
		}  catch (InternalServerException e) {
			LOG.error("InternalServerException", e);
		} catch (RequestFailedException e) {
			LOG.error("RequestFailedException", e);
		} catch (RemoteException e) {
			LOG.error("RemoteException", e);
		} catch (IOException e) {
			LOG.error(e);
		}
		return null;
	}
	
	public int verify(byte[] unsignData, String workerName) {
		int validateCode = 100;
		try {					
			SSLHandler ssl = new SSLHandler();
			ssl.setSSL();
			
			ClientWSProxy proxy = new ClientWSProxy(GlobalConfig.getProperty(GlobalConfig.SIGNSERVER_ENPOINT));
			ClientWS clientWS = proxy.getClientWS();
	
		
			ValidationDataResponse dataResponse = clientWS.verify(workerName, null, unsignData);
			validateCode = dataResponse.getValidateCode();			
		} catch (InternalServerException e) {
			LOG.error("InternalServerException", e);
		} catch (RequestFailedException e) {
			LOG.error("RequestFailedException", e);
		} catch (RemoteException e) {
			LOG.error("RemoteException", e);
		}catch (IOException e) {
			LOG.error(e);
		}
		
		return validateCode;
	}
}
