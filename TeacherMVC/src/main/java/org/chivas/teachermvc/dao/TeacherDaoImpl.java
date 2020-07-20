
package org.chivas.teachermvc.dao;

import java.util.List;
import org.chivas.teachermvc.entities.Teacher;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vagos
 */
@Repository("teacherDao")
public class TeacherDaoImpl extends AbstractDao<Integer, Teacher> implements ITeacherDao{

     @Override
    public List<Teacher> findAll() {
        Criteria criteria = createEntityCriteria();
	return (List<Teacher>) criteria.list();
    }

    public boolean save(Teacher teacher) {
        boolean notSaved = persist(teacher);
        if(notSaved) return false;
        return true;
    }

    public boolean delete(int id) {
        Teacher t = getByKey(id);
        if(t != null) {
            delete(t);
            if(getByKey(id) == null) 
                return true;
        }
        return false;
    }

    public Teacher findById(int id) {
        Teacher t = getByKey(id);
        if(t != null) {
            return t;
        }
        return null;
    }

    public boolean update(Teacher teacher) {
        Teacher db_teacher = findById(teacher.getId());
        if(db_teacher != null) {
            db_teacher.setFirstName(teacher.getFirstName());
            db_teacher.setLastName(teacher.getLastName());
            db_teacher.setSubject(teacher.getSubject());   
            return save(db_teacher);
        } else
            return false;
    }
    
    
    
}
