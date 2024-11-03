package be_project1.pet_project.service.impl;

import be_project1.pet_project.dto.request.CourseSearchReq;
import be_project1.pet_project.dto.response.CourseSearchRes;
import be_project1.pet_project.entity.Course;
import be_project1.pet_project.repository.CourseRepository;
import be_project1.pet_project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Object searchCourse(CourseSearchReq req) {
        //
        req.setPageIndex(req.getPageIndex() != null && req.getPageIndex() >= 0 ? req.getPageIndex() : 0);
        req.setPageSize(req.getPageSize() != null && req.getPageSize() >= 1 ? req.getPageSize() : 1);

        //
        Sort sort = Sort.by(Sort.Direction.DESC, "created_date");
        if(req.getSort() != null && !req.getSort().isEmpty()) {
            //
            sort = Sort.unsorted();

            //
            for(CourseSearchReq.CourseSort sortC : req.getSort()) {
                //
                if(CourseSearchReq.CourseSort.ASC.equalsIgnoreCase(sortC.getOrder())) {
                    sort = sort.and(Sort.by(Sort.Direction.ASC, sortC.getField()));
                } else if(CourseSearchReq.CourseSort.DESC.equalsIgnoreCase(sortC.getOrder())) {
                    sort = sort.and(Sort.by(Sort.Direction.DESC, sortC.getField()));
                }
            }
        }

        //
        Pageable pageable = PageRequest.of(req.getPageIndex(), req.getPageSize(), sort);

        //
        List<Course> courses = courseRepository.searchCourse(
            req.getName(),
            req.getCreatedDateFrom(),
            req.getCreatedDateTo(),
            req.getStatus(),
            req.getUserId(),
            req.getNumberOfLessonFrom(),
            req.getNumberOfLessonTo(),
            req.getRatingFrom(),
            req.getRatingTo(),
            pageable
        );

        //
        Long totalItems = courseRepository.countItemSearchCourse(
            req.getName(),
            req.getCreatedDateFrom(),
            req.getCreatedDateTo(),
            req.getStatus(),
            req.getUserId(),
            req.getNumberOfLessonFrom(),
            req.getNumberOfLessonTo(),
            req.getRatingFrom(),
            req.getRatingTo()
        );

        //
        return new CourseSearchRes(totalItems, courses);
    }
}