package mx.erick

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SellerController {

    SellerService sellerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sellerService.list(params), model:[sellerCount: sellerService.count()]
    }

    def show(Long id) {
        respond sellerService.get(id)
    }

    def create() {
        respond new Seller(params)
    }

    def save(Seller seller) {
        if (seller == null) {
            notFound()
            return
        }

        try {
            sellerService.save(seller)
        } catch (ValidationException e) {
            respond seller.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'seller.label', default: 'Seller'), seller.id])
                redirect seller
            }
            '*' { respond seller, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sellerService.get(id)
    }

    def update(Seller seller) {
        if (seller == null) {
            notFound()
            return
        }

        try {
            sellerService.save(seller)
        } catch (ValidationException e) {
            respond seller.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'seller.label', default: 'Seller'), seller.id])
                redirect seller
            }
            '*'{ respond seller, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sellerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'seller.label', default: 'Seller'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'seller.label', default: 'Seller'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
