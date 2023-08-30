package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.model.Usermodel;
import com.example.demo.repository.Userrepo;
@Service
public class Userservice {
	@Autowired
	Userrepo cr;
	public Usermodel saveinfo(Usermodel cm)
	{
		return cr.save(cm);

	}

	public List<Usermodel> saveninfo(List<Usermodel> cm)

	{

		return (List<Usermodel>)cr.saveAll(cm);

	}

	public List<Usermodel> showinfo()

	{

		return cr.findAll();

	}

	public Optional<Usermodel> showbyid(int custid)

	{

		return cr.findById(custid);

	}

	public Usermodel changeinfo(Usermodel cm)

	{

		return cr.saveAndFlush(cm);

	}

	public String updateinfobyid(int custid,Usermodel cm)

	{

		cr.saveAndFlush(cm);

		if(cr.existsById(custid))

		{

			return "Updated";

		}

		else

		{

			return "Enter valid id";

		}

	}

	public void deleteinfo(Usermodel cm)

	{

		cr.delete(cm);

	}

	public void deleteid(int custid)

	{

		cr.deleteById(custid);

	}

	public List<Usermodel> sortinfo(String s)

	{

		return cr.findAll(Sort.by(Sort.DEFAULT_DIRECTION, s));

	}

	public List<Usermodel> getbypage(int pagno,int pagsize)

	{

		Page<Usermodel> p=cr.findAll(PageRequest.of(pagno, pagsize));

		return p.getContent();

	}

	public List<Usermodel> getpage(int pagno,int pagsize)

	{

		PageRequest pq=PageRequest.of(pagno, pagsize,Sort.by("custname").descending());

		Page<Usermodel> pm=cr.findAll(pq);

		return pm.getContent();
	}

	public List<Usermodel> getcust(int s,String b)
	{
		return cr.getcustinfo(s, b);
	}
	public Integer deletecust(int s)
	{
		return cr.deletecustinfo(s);
	}
	public int  updatecust(int id,int id1)
	{
		return cr.updatecustinfo(id, id1);

	}

}