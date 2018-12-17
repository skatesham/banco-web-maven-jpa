package br.sham.web.banco.api.util;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Hash {
	
	public static String criptografar(String senha) {
		return Hashing.sha256().hashString(senha, StandardCharsets.UTF_8).toString();
	}
	
}
