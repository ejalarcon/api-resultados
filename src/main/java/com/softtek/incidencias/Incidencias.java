package com.softtek.incidencias;


public class Incidencias {
	
	private String _id;
	private String grupo;
	private String estado;
	private String baja;
	private String media;
	private String alta;
	private String critica;
	
	

	public String get_id()
	{
		return _id;
	}
	public void set_id(String _id)
	{
		this._id = _id;
	}
	public String getEstado()
	{
		return estado;
	}
	public void setEstado(String estado)
	{
		this.estado = estado;
	}
	public String getBaja()
	{
		return baja;
	}
	public void setBaja(String baja)
	{
		this.baja = baja;
	}
	public String getMedia()
	{
		return media;
	}
	public void setMedia(String media)
	{
		this.media = media;
	}
	public String getAlta()
	{
		return alta;
	}
	public void setAlta(String alta)
	{
		this.alta = alta;
	}
	public String getCritica()
	{
		return critica;
	}
	public void setCritica(String critica)
	{
		this.critica = critica;
	}

	public String getGrupo()
	{
		return grupo;
	}
	public void setGrupo(String grupo)
	{
		this.grupo = grupo;
	}


}
