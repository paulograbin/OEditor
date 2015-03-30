package com.unisinos.devweb.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Gerenciador {

	private static Gerenciador service;
	private File appDir;
	private File resDir;
	
	public Gerenciador() { }
	
	public static Gerenciador getGerenciador() {
		if (service == null)
			service = new Gerenciador();
		
		return service;
	}
	
	public void init(String path) {
		appDir = new File(path);
		resDir = new File(path + "/res");
		
		System.out.println("Diretório dos arquivos salvos é " + resDir);
		
		verificaExistenciaDiretorio();
	}
	
	private void verificaExistenciaDiretorio() {
		System.out.println("Verificando se diretório existe...");
		
		if (resDir.isDirectory() && resDir.exists()) {
			System.out.println("Existe!");
//			getResDirInfo();
		} else {
			System.out.println("Não existe, criando...");
			criaDiretorioRes();
		}
	}
	
	private void criaDiretorioRes() {
		
		if (appDir.canWrite()) {
			resDir.mkdir();
			System.out.println("Diretório criado!");
		} else {
			System.out.println("Não é possivel escrever na pasta do projeto...");
		}
	}
	
	private void getResDirInfo() {
		System.out.println("Tem " + getFileCount() + " arquivos.");
		
		System.out.println("Can execute: \t\t" + resDir.canExecute());
		System.out.println("Can read: \t\t" + resDir.canRead());
		System.out.println("Can write: \t\t" + resDir.canWrite());
		System.out.println("Absolute Path: \t\t" + resDir.getAbsolutePath());
//		System.out.println("\t\t" + resDir.getCanonicalPath());
		System.out.println("Free space: \t\t" + resDir.getFreeSpace());
		System.out.println("Name: \t\t\t" + resDir.getName());
		System.out.println("Parent: \t\t" + resDir.getParent());
		System.out.println("Path: \t\t\t" + resDir.getPath());
		System.out.println("TotalSpace: \t\t" + resDir.getTotalSpace());
		System.out.println("Usable Space: \t\t" + resDir.getUsableSpace());
		System.out.println("HashCode: \t\t" + resDir.hashCode());
		System.out.println("Is absolute: \t\t" + resDir.isAbsolute());
		System.out.println("Is directory: \t\t" + resDir.isDirectory());
		System.out.println("Is file: \t\t" + resDir.isFile());
		System.out.println("Is hidden: \t\t" + resDir.isHidden());
		System.out.println("Last Modified: \t\t" + resDir.lastModified());
	}
	
	public int getFileCount() {
		System.out.println("Contando arquivos..." + resDir.listFiles().length);
		return resDir.listFiles().length;
	}
	
	public ArrayList<Texto> getTextos() {
		ArrayList<Texto> textos = new ArrayList<Texto>();
		
		for(File f : getFiles()) {
			if (f.isFile())
				textos.add(new Texto(1, getConteudoFromFile(f.getAbsolutePath())));
		}
		
		return textos;
	}
	
	private File[] getFiles() {
		File[] files = resDir.listFiles();
		
//		System.out.println("Encontramos " + files.length + " arquivos...");
//		for(int i = 0; i < files.length; i++) {
//			System.out.println(files[i].getAbsolutePath());
//		}
		
		return files;
	}
	
	private String getConteudoFromFile(String path) {
		StringBuilder sb = new StringBuilder();
		String line;
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(path));
			
			while((line = bf.readLine()) != null) {
				sb.append(line);
		    }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
}
