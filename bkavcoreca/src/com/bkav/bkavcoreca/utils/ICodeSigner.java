package com.bkav.bkavcoreca.utils;

import com.bkav.bkavsignature.utils.BkavSignaturesException;

public interface ICodeSigner {
	public byte[] signJar(byte[] data) throws BkavSignaturesException;
	public byte[] signExe(byte[] data) throws BkavSignaturesException;
}
