package mx.erick

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SellerServiceSpec extends Specification {

    SellerService sellerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Seller(...).save(flush: true, failOnError: true)
        //new Seller(...).save(flush: true, failOnError: true)
        //Seller seller = new Seller(...).save(flush: true, failOnError: true)
        //new Seller(...).save(flush: true, failOnError: true)
        //new Seller(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //seller.id
    }

    void "test get"() {
        setupData()

        expect:
        sellerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Seller> sellerList = sellerService.list(max: 2, offset: 2)

        then:
        sellerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sellerService.count() == 5
    }

    void "test delete"() {
        Long sellerId = setupData()

        expect:
        sellerService.count() == 5

        when:
        sellerService.delete(sellerId)
        sessionFactory.currentSession.flush()

        then:
        sellerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Seller seller = new Seller()
        sellerService.save(seller)

        then:
        seller.id != null
    }
}
