
package org.chivas.teachermvc.dao;

import java.util.List;
import org.chivas.teachermvc.entities.Teacher;

/**
 *
 * @author Vagos
 */
public interface ITeacherDao {
    public List<Teacher> findAll();
    public Teacher findById(int id);
    public boolean save(Teacher teacher);
    public boolean delete(int id);
    public boolean update(Teacher teacher);
}
