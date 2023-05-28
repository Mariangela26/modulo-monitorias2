package com.unisimon.monitorias.chapter.infrastructure.configuration;

import com.unisimon.monitorias.chapter.domain.api.ICourseServicePort;
import com.unisimon.monitorias.chapter.domain.api.IInstructorServicePort;
import com.unisimon.monitorias.chapter.domain.api.IScheduleServicePort;
import com.unisimon.monitorias.chapter.domain.spi.ICoursePersistencePort;
import com.unisimon.monitorias.chapter.domain.spi.IInstructorPersistencePort;
import com.unisimon.monitorias.chapter.domain.spi.ISchedulePersistencePort;
import com.unisimon.monitorias.chapter.domain.usecase.CourseUseCase;
import com.unisimon.monitorias.chapter.domain.usecase.InstructorUseCase;
import com.unisimon.monitorias.chapter.domain.usecase.ScheduleUseCase;
import com.unisimon.monitorias.chapter.infrastructure.persistence.adapter.CourseJpaAdapter;
import com.unisimon.monitorias.chapter.infrastructure.persistence.adapter.InstructorJpaAdapter;
import com.unisimon.monitorias.chapter.infrastructure.persistence.adapter.ScheduleJpaAdapter;
import com.unisimon.monitorias.chapter.infrastructure.persistence.mapper.CourseEntityMapper;
import com.unisimon.monitorias.chapter.infrastructure.persistence.mapper.InstructorEntityMapper;
import com.unisimon.monitorias.chapter.infrastructure.persistence.mapper.ScheduleEntityMapper;
import com.unisimon.monitorias.chapter.infrastructure.persistence.repository.ICourseRepository;
import com.unisimon.monitorias.chapter.infrastructure.persistence.repository.IInstructorRepository;
import com.unisimon.monitorias.chapter.infrastructure.persistence.repository.IScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICourseRepository courseRepository;
    private final IInstructorRepository instructorRepository;
    private final IScheduleRepository scheduleRepository;

    private final CourseEntityMapper courseEntityMapper;
    private final InstructorEntityMapper instructorEntityMapper;
    private final ScheduleEntityMapper scheduleEntityMapper;

    @Bean
    public ICoursePersistencePort coursePersistencePort(){
        return new CourseJpaAdapter(courseRepository, courseEntityMapper);
    }
    @Bean
    public ICourseServicePort courseServicePort(){
        return new CourseUseCase(coursePersistencePort());
    }

    @Bean
    public IInstructorPersistencePort instructorPersistencePort(){
        return new InstructorJpaAdapter(instructorRepository, instructorEntityMapper);
    }
    @Bean
    public IInstructorServicePort instructorServicePort(){
        return new InstructorUseCase(instructorPersistencePort());
    }

    @Bean
    public ISchedulePersistencePort schedulePersistencePort (){
        return new ScheduleJpaAdapter(scheduleRepository, scheduleEntityMapper);
    }
    @Bean
    public IScheduleServicePort scheduleServicePort(){
        return new ScheduleUseCase(schedulePersistencePort());
    }
}
