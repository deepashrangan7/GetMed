package com.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.RecoveryBean;
import com.project.service.AdminDao;
import com.project.service.RecoveryDao;

@Service
public class PasswordRecoveryFunction {

@Autowired
RecoveryDao dao;

@Autowired
AdminDao adao;

public RecoveryBean update(String id,String question,String answer)
{
RecoveryBean rb;

if(question.equals("q1"))
{
rb = dao.Validate(id,answer);
}
else if(question.equals("q2"))
{
rb = dao.Validate1(id,answer);
}
else
{
rb = dao.Validate2(id,answer);
}


return rb;
}

public int updatepassword(String password,String username)
{

int a=adao.updatepassword(username,password);

return a;
}



}