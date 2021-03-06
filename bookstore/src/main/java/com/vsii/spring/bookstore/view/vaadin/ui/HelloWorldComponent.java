package com.vsii.spring.bookstore.view.vaadin.ui;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;


public class HelloWorldComponent extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button clickMeBtn;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2432450035427546044L;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public HelloWorldComponent() {

		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {

		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// clickMeBtn
		clickMeBtn = new Button();
		clickMeBtn.setCaption("Click Me");
		clickMeBtn.setImmediate(false);
		clickMeBtn.setWidth("-1px");
		clickMeBtn.setHeight("-1px");
		mainLayout.addComponent(clickMeBtn, "top:80.0px;left:120.0px;");
		
		return mainLayout;
	}

}
