package com.badass



import org.junit.*
import grails.test.mixin.*

@TestFor(ActivityDetailController)
@Mock(ActivityDetail)
class ActivityDetailControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/activityDetail/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.activityDetailInstanceList.size() == 0
        assert model.activityDetailInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.activityDetailInstance != null
    }

    void testSave() {
        controller.save()

        assert model.activityDetailInstance != null
        assert view == '/activityDetail/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/activityDetail/show/1'
        assert controller.flash.message != null
        assert ActivityDetail.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/activityDetail/list'

        populateValidParams(params)
        def activityDetail = new ActivityDetail(params)

        assert activityDetail.save() != null

        params.id = activityDetail.id

        def model = controller.show()

        assert model.activityDetailInstance == activityDetail
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/activityDetail/list'

        populateValidParams(params)
        def activityDetail = new ActivityDetail(params)

        assert activityDetail.save() != null

        params.id = activityDetail.id

        def model = controller.edit()

        assert model.activityDetailInstance == activityDetail
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/activityDetail/list'

        response.reset()

        populateValidParams(params)
        def activityDetail = new ActivityDetail(params)

        assert activityDetail.save() != null

        // test invalid parameters in update
        params.id = activityDetail.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/activityDetail/edit"
        assert model.activityDetailInstance != null

        activityDetail.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/activityDetail/show/$activityDetail.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        activityDetail.clearErrors()

        populateValidParams(params)
        params.id = activityDetail.id
        params.version = -1
        controller.update()

        assert view == "/activityDetail/edit"
        assert model.activityDetailInstance != null
        assert model.activityDetailInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/activityDetail/list'

        response.reset()

        populateValidParams(params)
        def activityDetail = new ActivityDetail(params)

        assert activityDetail.save() != null
        assert ActivityDetail.count() == 1

        params.id = activityDetail.id

        controller.delete()

        assert ActivityDetail.count() == 0
        assert ActivityDetail.get(activityDetail.id) == null
        assert response.redirectedUrl == '/activityDetail/list'
    }
}
