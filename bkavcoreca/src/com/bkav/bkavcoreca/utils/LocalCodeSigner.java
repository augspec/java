//package com.bkav.bkavcoreca.utils;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//
//import org.apache.log4j.Logger;
//
//import com.bkav.bkavsignature.codesigning.ExeSigner;
//import com.bkav.bkavsignature.jar.JarSigner;
//import com.bkav.bkavsignature.utils.BkavSignaturesException;
//
//public class LocalCodeSigner implements ICodeSigner {
//	private static final Logger LOG = Logger.getLogger(LocalCodeSigner.class);
//
//	@Override
//	public byte[] signJar(byte[] data) throws BkavSignaturesException {
//		if (data == null) {
//			throw new BkavSignaturesException("No input data");
//		}
//		String keystorePath = GlobalConfig
//				.getProperty(GlobalConfig.PKCS12_PATH);
//		String keystorePass = GlobalConfig
//				.getProperty(GlobalConfig.PKCS12_PASS);
//		InputStream inStream = null;
//		try {
//			inStream = new FileInputStream(keystorePath);
//		} catch (FileNotFoundException e) {
//			LOG.error("FileNotFoundException", e);
//			throw new BkavSignaturesException("Local signer unavilable");
//		}
//		com.bkav.bkavsignature.utils.CryptoToken token = null;
//		try {
//			token = com.bkav.bkavsignature.utils.CryptoTokenUtil
//					.initFromPkcs12(inStream, keystorePass);
//		} catch (BkavSignaturesException e) {
//			LOG.error("BkavSignaturesException", e);
//			throw new BkavSignaturesException(e.getMessage());
//		}
//		if (token == null) {
//			return null;
//		}
//		byte[] signed = JarSigner.sign(data, token, ExeSigner.TSA_URL);
//		return signed;
//	}
//
//	@Override
//	public byte[] signExe(byte[] data) throws BkavSignaturesException {
//		if (data == null) {
//			throw new BkavSignaturesException("No input data");
//		}
//		String keystorePath = GlobalConfig
//				.getProperty(GlobalConfig.PKCS12_PATH);
//		String keystorePass = GlobalConfig
//				.getProperty(GlobalConfig.PKCS12_PASS);
//		InputStream inStream = null;
//		try {
//			inStream = new FileInputStream(keystorePath);
//		} catch (FileNotFoundException e) {
//			LOG.error("FileNotFoundException", e);
//			throw new BkavSignaturesException("Local signer unavilable");
//		}
//		com.bkav.bkavsignature.utils.CryptoToken token = null;
//		try {
//			token = com.bkav.bkavsignature.utils.CryptoTokenUtil
//					.initFromPkcs12(inStream, keystorePass);
//		} catch (BkavSignaturesException e) {
//			LOG.error("BkavSignaturesException", e);
//			throw new BkavSignaturesException(e.getMessage());
//		}
//		if (token == null) {
//			return null;
//		}
//		try {
//			byte[] signed = ExeSigner.sign(data, token, ExeSigner.TSA_URL);
//			return signed;
//		} catch (BkavSignaturesException e) {
//			LOG.error("BkavSignaturesException", e);
//			throw new BkavSignaturesException(e.getMessage());
//		}
//	}
//
//}
