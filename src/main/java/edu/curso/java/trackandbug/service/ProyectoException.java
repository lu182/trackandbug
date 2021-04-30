package edu.curso.java.trackandbug.service;

public class ProyectoException extends Exception {
	
	//Sobreescribimos estos métodos constructores:
	
		public ProyectoException(String message ) { //Creamos excepcion propia donde le pasamos un mensaje.
			
			super(message); //recibe un mensaje de error (meramente informativo)
		}
		
		public ProyectoException(String message, Throwable errorBase ) { //Creamos excepcion propia donde le pasamos un mensaje y un Throwable
			
			super(message, errorBase); //recibe un mensaje de error + el errorBase: 
		}
}
