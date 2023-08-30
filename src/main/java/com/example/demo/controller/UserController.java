package com.example.demo.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Usermodel;
import com.example.demo.service.Userservice;
@RestController
public class UserController {
	@Autowired

	Userservice cs;

	//to create the data

	@PostMapping("adduser")

	public Usermodel add(@RequestBody Usermodel cm)

	{

		return cs.saveinfo(cm);
	}
	@PostMapping("addnuser")
	public List<Usermodel> addn(@RequestBody List<Usermodel> cm)
	{
		return cs.saveninfo(cm);

	}
	@GetMapping("showuser")
	public List<Usermodel> show()
	{
 	return cs.showinfo();

	}

	@GetMapping("showbyid/{userid}")
	public Optional<Usermodel> showid(@PathVariable int userid)
	{
		return cs.showbyid(userid);
	}
	//to update the data

	@PutMapping("changeuser")
    public Usermodel modify(@RequestBody Usermodel cm)
    {
    	return cs.changeinfo(cm);
    }
	//update by id

	@PutMapping("updatebyid/{userid}")
	public String modifybyid(@PathVariable int userid,@RequestBody Usermodel cm)
	{

		return cs.updateinfobyid(userid, cm);

	}

    //to delete the data

	@DeleteMapping("deleteuser")

    public String del(@RequestBody Usermodel cm)

    {
    	cs.deleteinfo(cm);

    	return "Data deleted successfully";

    }

	//delete by id through Path variable

	@DeleteMapping("delid/{custid}")

	public void deletebyid(@PathVariable int custid)

	{

		cs.deleteid(custid);

	}

	

	//delete by id through Request parameter

	@DeleteMapping("delparaid")

	public void deletepid(@RequestParam int custid)

	{

		cs.deleteid(custid);

	}
	@GetMapping("sort/{custname}")

	public List<Usermodel> getsortinfo(@PathVariable String custname)

	{

		return cs.sortinfo(custname);

	}

	@GetMapping("paging/{pagno}/{pagsize}")

	public List<Usermodel> showpageinfo(@PathVariable int pagno,@PathVariable int pagsize)

	{

		return cs.getbypage(pagno, pagsize);

	}

	@GetMapping("getsortpag/{pagno}/{pagsize}")

	public List<Usermodel> showsortpageinfo(@PathVariable int pagno,@PathVariable int pagsize)

	{

		return cs.getpage(pagno, pagsize);

	}

	@GetMapping("get/{custid}/{custname}")

    public List<Usermodel> display(@PathVariable int custid,@PathVariable String custname)

    {

    	return cs.getcust(custid, custname);

    }

    @DeleteMapping("delete/{custid}")

    public String delete(@PathVariable int custid)

    {

    	return cs.deletecust(custid)+" Deleted";

    }

    @PutMapping("update/{id}/{id1}")

    public String update(@PathVariable ("id")int s,@PathVariable("id1") int s1)

    {

    	return cs.updatecust(s, s1)+" Updated";

    }

}