package service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import dao.QrCodeDao;
import domain.QrCode;

public class QrCodeService {
	
	@Inject  
	private QrCodeDao qrcodeDao;
	
	public QrCodeService() {}
	
	@Transactional
	public void addCardapio(QrCode qrcode){
		
		qrcodeDao.inserir(qrcode);
		
	}
	
	@Transactional
	public void removeQrCode(QrCode qrcode){
		qrcodeDao.remover(qrcode);
	}
	
	@Transactional
	public void updateQrCode(QrCode qrcode){
		qrcodeDao.atualizar(qrcode);
	}
	
	@Transactional
	public void findById(QrCode qrcode){
		qrcodeDao.findById(qrcode);
	}
	

	@Transactional
	public List<QrCode> findAll(){
		return qrcodeDao.findAll();
	}

	@Transactional
	public QrCodeDao getQrCodeDao() {
		return qrcodeDao;
	}

	@Transactional
	public void setQrCodeDao(QrCodeDao qrcodeDao) {
		this.qrcodeDao = qrcodeDao;
	}

}