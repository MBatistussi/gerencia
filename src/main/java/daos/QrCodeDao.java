package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.QrCode;

@Stateless
public class QrCodeDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void inserir(QrCode QRCode) {
		entityManager.persist(QRCode);
	}
	
	public void remover(QrCode QRCode) {
		
		QRCode = entityManager.find(QrCode.class, QRCode);
		entityManager.remove(QRCode);
		
	}
	
	
	public void atualizar(QrCode QRCode) {
		entityManager.merge(QRCode);
		
	}
	public QrCode findById(QrCode QRCode) {

          return (QrCode) entityManager.find(QrCode.class, QRCode.getIdQRCode());
		
	 }
	
//	public void removeAll() {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Query qr = session.createQuery("DELETE FROM QRCodes");
//		qr.executeUpdate();
//		
//	}
	
	@SuppressWarnings("unchecked")
	public List<QrCode> findAll() {
		String qs = "SELECT e FROM qrcode e";
		Query qr = entityManager.createQuery(qs);
		return (List<QrCode>) qr.getResultList();
				
	}	

}
