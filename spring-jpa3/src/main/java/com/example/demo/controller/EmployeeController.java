package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

/**
 * 社員情報のコントローラークラス
 * @author PCUser
 *
 */
@RequiredArgsConstructor
@Controller
public class EmployeeController {

	/** 定数 社員情報用インターフェイス格納 */
	private final EmployeeRepository repository;
	
	/**
	 * 最初の遷移画面
	 * @param model
	 * @return index
	 */
	@GetMapping("/")
	public String showList(Model model) {
		model.addAttribute("employees", repository.findAll());
		return "index";
	}
	
	/**
	 * 社員情報を表示
	 * @param employee
	 * @return form
	 */
	@GetMapping("/add")
	public String addEmployee(@ModelAttribute Employee employee) {
		return"form";
	}
	
	/**
	 * 社員情報の追加
	 * @param employee
	 * @param result
	 * @return form
	 * @return redirect:/
	 */
	@PostMapping("/process")
	public String process(@Validated @ModelAttribute Employee employee, BindingResult result) {
		
		// 入力値にエラーがある場合、フォームへ
		if(result.hasErrors()) {
			return "form";
		}
		
		// 入力値に問題がなければ保存
		repository.save(employee);
		
		// 最初の画面へリダイレクト
		return "redirect:/";
	}
	
	/**
	 * 社員情報の更新
	 * @param id
	 * @param model
	 * @return form
	 */
	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable Long id, Model model) {
		
		// 更新する社員ID
		model.addAttribute("employee", repository.findById(id));
		return "form";
	}
	
	/**
	 * 社員情報の削除
	 * @param id
	 * @return redirect:/
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/";
	}
}
