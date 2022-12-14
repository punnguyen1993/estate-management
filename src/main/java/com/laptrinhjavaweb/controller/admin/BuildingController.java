package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchRespone;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.DisplayTagUtils;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {

	@Autowired
	private IBuildingService buildingService;
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
	public ModelAndView buildingList(@ModelAttribute(SystemConstant.MODEL_SEARCH) BuildingSearchRequest buildingSearchRequest,
									 @ModelAttribute(SystemConstant.TABLE_MODEL) BuildingSearchRespone buildingSearchResponse,
									 HttpServletRequest request) {
		DisplayTagUtils.of(request, buildingSearchResponse);
		ModelAndView mav = new ModelAndView("admin/building/list");

		List<BuildingSearchRespone> buildings;
 		if(buildingSearchRequest.isSearch()){
			buildings = buildingService.findByDetail(buildingSearchRequest, PageRequest.of(buildingSearchRequest.getPage() - 1, buildingSearchRequest.getMaxPageItems()));
			buildingSearchResponse.setTotalItems(buildingService.countAllSearchBuilding(buildingSearchRequest));
		}else{
			buildings = buildingService.findAll(PageRequest.of(buildingSearchResponse.getPage() - 1, buildingSearchResponse.getMaxPageItems()));
			buildingSearchResponse.setTotalItems(buildingService.countAll());
		}

		buildingSearchResponse.setListResult(buildings);

		mav.addObject(SystemConstant.MODEL_SEARCH, buildingSearchRequest);
		mav.addObject(SystemConstant.TABLE_MODEL, buildingSearchResponse);
		mav.addObject(SystemConstant.TYPES, buildingService.getTypes());
		mav.addObject(SystemConstant.DISTRICTS, buildingService.getDistricts());
		mav.addObject("staffmaps", userService.getStaffMaps());

		return mav;
	}


	@RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
	public ModelAndView buildingAdd(@ModelAttribute(SystemConstant.MODEL_ADDING) BuildingDTO buildingDTO) {

		ModelAndView mav = new ModelAndView("admin/building/edit");
		mav.addObject(SystemConstant.BUTTON_NAME, SystemConstant.BUILDING_ADDING_BUTTON_NAME);

		mav.addObject(SystemConstant.DISTRICTS, buildingService.getDistricts());
		mav.addObject(SystemConstant.TYPES, buildingService.getTypes());
		return mav;
	}


    @RequestMapping(value = "/admin/building-edit-{id}", method = RequestMethod.GET)
    public ModelAndView buildingEdit(@ModelAttribute(SystemConstant.MODEL_ADDING) BuildingDTO buildingDTO,
                                     @PathVariable(value = "id") Long id) {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        mav.addObject(SystemConstant.BUTTON_NAME, SystemConstant.BUILDING_UPDATE_BUTTON_NAME);

        if(ValidateUtils.isValid(id)){
            mav.addObject(SystemConstant.MODEL_ADDING, buildingService.findById(id));
        }else {
            mav.addObject(SystemConstant.MODEL_ADDING, buildingDTO);
        }

        /*districts & types ??? ngo??i view edit.jsp s??? render ra checkbox (??? form:checkbox t???i items=)
		c??n buildingDTO tr??? ra view c?? field district, buildingType s??? checked v??o checkbox*/

		mav.addObject(SystemConstant.DISTRICTS, buildingService.getDistricts());
		mav.addObject(SystemConstant.TYPES, buildingService.getTypes());
        return mav;
    }

    @RequestMapping(value = "/admin/building-info-{id}", method = RequestMethod.GET)
	public ModelAndView buildingInfor(@PathVariable(value = "id") Long id){
		ModelAndView mav = new ModelAndView("admin/building/edit");
		if(id != null){
			mav.addObject(SystemConstant.MODEL_ADDING, 	buildingService.findById(id));
			mav.addObject("isInfo", true);
		}
		mav.addObject(SystemConstant.DISTRICTS, buildingService.getDistricts());
		mav.addObject(SystemConstant.TYPES, buildingService.getTypes());
		return mav;
	}
}
