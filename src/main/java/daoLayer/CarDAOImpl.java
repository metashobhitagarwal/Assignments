package daoLayer;

import java.util.List;

import javax.transaction.Transactional;

import model.CarVO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CarDAOImpl {

	//private static final Logger logger = LoggerFactory.getLogger(CarVO.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addCar(CarVO car) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(car);
	}

	public void updateCar(CarVO car) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(car);
	}

	@SuppressWarnings("unchecked")
	public List<CarVO> listCars() {
		Session session = this.sessionFactory.getCurrentSession();
		List<CarVO> carsList = session.createQuery("from CarVO").list();
		/*for(CarVO car : carsList){
			logger.info("Person List::"+p);
		}*/
		return carsList;
	}

	public CarVO getCarById(String id){
		Session session = this.sessionFactory.getCurrentSession();
		CarVO car = (CarVO) session.load(CarVO.class, id);
		return car;
	}
}