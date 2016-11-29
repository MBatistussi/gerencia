package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QrCode {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idQRCode;
	
	@Column(nullable=false)
	private String pathImage;
	
	private int numeroMesa;
	
	public QrCode(){
		
	}
	
	public QrCode(int idQRCode, String pathImage, int numeroMesa){
		this.idQRCode = idQRCode;
		this.pathImage = pathImage;
		this.numeroMesa = numeroMesa;
	}

	public int getIdQRCode() {
		return idQRCode;
	}

	public void setIdQRCode(int idQRCode) {
		this.idQRCode = idQRCode;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public int getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
	
	
}
