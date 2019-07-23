package com.lambdaschool.school;

import com.lambdaschool.school.model.*;
import com.lambdaschool.school.repository.InstructorRepository;
import com.lambdaschool.school.repository.RoleRepository;
import com.lambdaschool.school.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;
    InstructorRepository instructorrepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos, InstructorRepository instructorrepos)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.instructorrepos = instructorrepos;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        Instructor instructor2 = new Instructor("Elon Musk");
        instructor2.getCourses().add(new Course("Space For Dummies"));
        instructorrepos.save(instructor2);



        Role role2 = new Role("user");

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), role2));

        User u2 = new User("garsee", "password", users);

        userrepos.save(u2);

    }
}