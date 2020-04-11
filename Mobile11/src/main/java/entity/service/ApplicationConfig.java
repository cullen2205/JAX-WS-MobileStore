/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author kenn8007
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(entity.service.TbAdminFacadeREST.class);
        resources.add(entity.service.TbCategoryFacadeREST.class);
        resources.add(entity.service.TbCommentFacadeREST.class);
        resources.add(entity.service.TbDiscountFacadeREST.class);
        resources.add(entity.service.TbImageFacadeREST.class);
        resources.add(entity.service.TbOrderFacadeREST.class);
        resources.add(entity.service.TbPostFacadeREST.class);
        resources.add(entity.service.TbProductFacadeREST.class);
        resources.add(entity.service.TbReviewFacadeREST.class);
        resources.add(entity.service.TbTokenFacadeREST.class);
        resources.add(entity.service.TbUserFacadeREST.class);
        resources.add(entity.service.TbUserTokenFacadeREST.class);
    }
    
}
