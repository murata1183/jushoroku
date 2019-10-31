package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * ユーザー情報 Controller
 */
@Controller

public class List_Controller {

	/**
	 * ユーザー情報 Service
	 */
	@Autowired
	List_Service list_Service;

	/**
	 * ユーザー情報一覧画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping(value = "Addlist")
	public String AddList(Model model) {
		List<List_Entity> Addlist = list_Service.searchAll();
		model.addAttribute("Addlist", Addlist);
		return "AddList";
	}
	/**
	 * ユーザー新規登録
	 * @param userRequest リクエストデータ
	 * @param model Model
	 */
	@RequestMapping(value = "SignUp" ,method = RequestMethod.POST)
	public String SignUp(Model model) {
		return "SignUp";
	}
	/**
	 * 新規登録の確認画面
	 */
	@RequestMapping(value ="/S_Confirmation", method = RequestMethod.POST)
	public String S_confirm(@ModelAttribute @Validated List_Entity list_Entity, Model model) {
		return "S_Confirmation";
	}
	/**
	 * 新規登録から一覧画面に戻る
	 */
	@PostMapping("/Addlist")
	public String create(@ModelAttribute List_Entity list_Entity, Model model) {
		list_Service.create(list_Entity);
		return "redirect:Addlist";
	}
	/**
	 * ユーザー編集画面
	}*/
	@GetMapping("/{No}/Edit")
	public String Edit(@PathVariable Long No, Model model) {
		List_Entity list_Entity = list_Service.findById(No);
		model.addAttribute("list_Entity", list_Entity);
		return "Edit";
	}
	/**
	 * 編集の確認画面
	}*/
	@RequestMapping(value = "/{No}/E_Confirmation" ,method = RequestMethod.POST)
	public String E_confirm(@ModelAttribute @Validated List_Entity list_Entity, Model model) {
		return "E_Confirmation";
	}
	/**
	 * 編集確認から一覧画面に戻る
	 */
	@PostMapping("E{No}")
	public String update(@PathVariable Long No, @ModelAttribute List_Entity list_Entity) {
		list_Entity.setId(No);
		list_Service.update(list_Entity);
		return "redirect:Addlist";
	}

	/**
	 * ユーザー削除画面
	 */
	@GetMapping("/{No}/Delete")
	public String Delete(@PathVariable Long No, Model model) {
		List_Entity list_Entity = list_Service.findById(No);
		model.addAttribute("list_Entity", list_Entity);
		return "Delete";
	}
	/**
	 * 削除から一覧画面に戻る
	 */
	@PostMapping("D{No}")
	public String Update(@PathVariable Long No, @ModelAttribute List_Entity list_Entity) {
		list_Entity.setId(No);
		list_Service.update(list_Entity);
		return "redirect:Addlist";
	}

	@GetMapping("Addback")
	public String Addback(Model model) {
		return "redirect:Addlist";
	}
	@PostMapping("ADDback")
	public String ADDback(Model model) {
		return "redirect:Addlist";
	}
	@PostMapping("/{No}/back")
	public String addback(Model model) {
		return "Addlist";
	}

	/**@PostMapping("/word/wordList")
    public String getWordList(Model model, Pageable pageable) {
        Page<List_Entity> wordsPage = list_Service.getAllWord(pageable);
        model.addAttribute("page", wordsPage);
        model.addAttribute("words", wordsPage.getContent());

        return "Addlist";
    }*/

}

