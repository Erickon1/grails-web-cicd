package mx.erick

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class SellerSpec extends Specification implements DomainUnitTest<Seller> {

     void "test domain constraints"() {
        when:
        Seller domain = new Seller()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
