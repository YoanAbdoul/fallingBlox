package fr.eseo.e3.poo.projet.blox.modele;

@SuppressWarnings("serial")
public class BloxException extends java.lang.Exception{
	public static final int BLOX_COLLISION = 1;
	public static final int BLOX_SORTIE_PUITS = 2;
	
	private int type;
	
	public BloxException(String message, int type)
	{
		super(message);
		this.type = type;
	}
	
	public int getType()
	{
		return this.type;
	}
}
