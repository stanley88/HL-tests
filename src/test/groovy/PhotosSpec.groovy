import spock.lang.Specification
import groovyx.net.http.RESTClient

class PhotosSpec extends Specification {
    def photoUrl = "https://jsonplaceholder.typicode.com"

    def "Photo endpoint GET returns photo collection with size 5000"() {
        setup:
        RESTClient restClient = new RESTClient(photoUrl)

        when:
        def response = restClient.get( path : "/photos")

        then:
        response.status == 200
        response.getData().size == 5000
    }

    def "Photo endpoint returns correct title for GET on single photo"() {
        setup:
        RESTClient restClient = new RESTClient(photoUrl)

        when:
        def response = restClient.get( path : "/photos/1")

        then:
        response.status == 200
        response.getData().title == "accusamus beatae ad facilis cum similique qui sunt"
    }
}