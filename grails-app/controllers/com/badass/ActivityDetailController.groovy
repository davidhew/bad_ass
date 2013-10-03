package com.badass

import org.springframework.dao.DataIntegrityViolationException

class ActivityDetailController {

	def activityDetailService
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [activityDetailInstanceList: ActivityDetail.list(params), activityDetailInstanceTotal: ActivityDetail.count()]
    }
	
	def search(){
		def results = activityDetailService.search(params)

		render(view:'list',model:[activityDetailInstanceList:results,activityDetailInstanceTotal:results.size(),params:params])
		return
	}

    def create() {
        [activityDetailInstance: new ActivityDetail(params)]
    }

    def save() {
        def activityDetailInstance = new ActivityDetail(params)
        if (!activityDetailInstance.save(flush: true)) {
            render(view: "create", model: [activityDetailInstance: activityDetailInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'activityDetail.label', default: 'ActivityDetail'), activityDetailInstance.id])
        redirect(action: "show", id: activityDetailInstance.id)
    }

    def show(Long id) {
        def activityDetailInstance = ActivityDetail.get(id)
        if (!activityDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'activityDetail.label', default: 'ActivityDetail'), id])
            redirect(action: "list")
            return
        }

        [activityDetailInstance: activityDetailInstance]
    }

    def edit(Long id) {
        def activityDetailInstance = ActivityDetail.get(id)
        if (!activityDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'activityDetail.label', default: 'ActivityDetail'), id])
            redirect(action: "list")
            return
        }

        [activityDetailInstance: activityDetailInstance]
    }

    def update(Long id, Long version) {
        def activityDetailInstance = ActivityDetail.get(id)
        if (!activityDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'activityDetail.label', default: 'ActivityDetail'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (activityDetailInstance.version > version) {
                activityDetailInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'activityDetail.label', default: 'ActivityDetail')] as Object[],
                          "Another user has updated this ActivityDetail while you were editing")
                render(view: "edit", model: [activityDetailInstance: activityDetailInstance])
                return
            }
        }

        activityDetailInstance.properties = params

        if (!activityDetailInstance.save(flush: true)) {
            render(view: "edit", model: [activityDetailInstance: activityDetailInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'activityDetail.label', default: 'ActivityDetail'), activityDetailInstance.id])
        redirect(action: "show", id: activityDetailInstance.id)
    }

    def delete(Long id) {
        def activityDetailInstance = ActivityDetail.get(id)
        if (!activityDetailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'activityDetail.label', default: 'ActivityDetail'), id])
            redirect(action: "list")
            return
        }

        try {
            activityDetailInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'activityDetail.label', default: 'ActivityDetail'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'activityDetail.label', default: 'ActivityDetail'), id])
            redirect(action: "show", id: id)
        }
    }
}
