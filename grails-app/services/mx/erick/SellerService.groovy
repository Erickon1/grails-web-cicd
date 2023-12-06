package mx.erick

import grails.gorm.services.Service

@Service(Seller)
interface SellerService {

    Seller get(Serializable id)

    List<Seller> list(Map args)

    Long count()

    void delete(Serializable id)

    Seller save(Seller seller)

}