
package org.chivas.teachermvc.services;

import java.util.List;
import org.chivas.teachermvc.dao.ITeacherDao;
import org.chivas.teachermvc.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vagos
 */
@Service("teacherService")
@Transactional
public class TeacherImpl implements ITeacher{
    
    @Autowired
	private ITeacherDao dao;

        @Override
    public List<Teacher> findAll() {
        List<Teacher> teachers = dao.findAll();
        return teachers;
    }

    public boolean save(Teacher teacher) {
        return dao.save(teacher);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }

    public boolean update(Teacher teacher) {
        teacher.setFirstName(teacher.getFirstName());
        teacher.setLastName(teacher.getLastName());
        teacher.setSubject(teacher.getSubject());
        dao.update(teacher);
        return true;
    }

    public Teacher findById(int id) {
        return dao.findById(id);
    }
    
    }
    

