package com.aug.web.util;

public class Constants {

	public static enum KeyInitVectorEncryptor {
		KEY("PMjiJYYO99&6%$_="), INIT_VECTOR("Q:Hk&^@-)985MnNN");
		
		private String value;
		
		private KeyInitVectorEncryptor(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
	}
}
