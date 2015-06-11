package org.sfbtmc.widget;

import org.sfbtmc.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
  
public class MainPageMenuPopWindow extends PopupWindow implements OnClickListener{
    private View conentView;  
    private OnPopMenuClickListener onMenuClickListener;
  
    public MainPageMenuPopWindow(final Activity context) {  
        LayoutInflater inflater = (LayoutInflater) context  
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
        conentView = inflater.inflate(R.layout.mainpage_popupwindow, null);  
        int h = context.getWindowManager().getDefaultDisplay().getHeight();  
        int w = context.getWindowManager().getDefaultDisplay().getWidth();  
        // 设置SelectPicPopupWindow的View  
        this.setContentView(conentView);  
        // 设置SelectPicPopupWindow弹出窗体的宽  
        this.setWidth(w / 2 + 50);  
        // 设置SelectPicPopupWindow弹出窗体的高  
        this.setHeight(LayoutParams.WRAP_CONTENT);  
        // 设置SelectPicPopupWindow弹出窗体可点击  
        this.setFocusable(true);  
        this.setOutsideTouchable(true);  
        // 刷新状态  
        this.update();  
        // 实例化一个ColorDrawable颜色为半透明  
        ColorDrawable dw = new ColorDrawable(0000000000);  
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作  
        this.setBackgroundDrawable(dw);  
        // mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);  
        // 设置SelectPicPopupWindow弹出窗体动画效果  
        this.setAnimationStyle(R.style.AnimationPreview); 
        
        
        conentView.findViewById(R.id.mainpage_pop_menu_exit).setOnClickListener(this);
        conentView.findViewById(R.id.mainpage_pop_menu_one).setOnClickListener(this);
        conentView.findViewById(R.id.mainpage_pop_menu_two).setOnClickListener(this);
        
    }  
  
    public void showPopupWindow(View parent) {  
        if (!this.isShowing()) {  
            this.showAsDropDown(parent, parent.getLayoutParams().width / 2, 18);  
        } else {  
            this.dismiss();  
        }  
    }  
    
    
    public OnPopMenuClickListener getOnMenuClickListener() {
		return onMenuClickListener;
	}

	public void setOnMenuClickListener(OnPopMenuClickListener onMenuClickListener) {
		this.onMenuClickListener = onMenuClickListener;
	}


	public interface OnPopMenuClickListener{
    	public void onClickMenu(View clickedMenu);
    	
    }


	@Override
	public void onClick(View arg0) {
		if(null == onMenuClickListener){
			return;
		}
		
		onMenuClickListener.onClickMenu(arg0);
	}
}  