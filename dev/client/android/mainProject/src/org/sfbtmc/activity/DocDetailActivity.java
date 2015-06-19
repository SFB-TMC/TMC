package org.sfbtmc.activity;

import org.sfbtmc.R;
import org.sfbtmc.widget.ArticleMenuPopWindow;
import org.sfbtmc.widget.MainPageMenuPopWindow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DocDetailActivity extends Activity {
	TextView tv1,tv2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doc_detail);
		tv1 = (TextView) findViewById(R.id.detail_content1);
		tv2 = (TextView) findViewById(R.id.detail_content2);
		//only for test
		String content = "Last night, I watched a tennis game, it was the US open, because there was a Chinese "
				+ "female player came to the semi-final, so I stayed up to watched the game. Unluckily, she was injured twice, "
				+ "though she still wanted to finish the game, her body situation did not allow her to do so. Her insistence moved "
				+ "so many audience, they gave her the biggest applause.The power of insistence is great, it will help you set free "
				+ "your potential and keep move on. Just for the players, they will face all kinds of incidences now and then, but the "
				+ "will to insist will make中文中文中文中文 them finish the game. Sometimes, people win the game not because of their excellent skills, "
				+ "but their strong will. Those who can stick on to the final line will win people’s applause.What’s more, when people insist "
				+ "to finish the game, it 中文中文is the respect that they show to their opponents. Their spirit deserves people’s applause. "
				+ "female player came to the semi-final, so I stayed up to wat中文中文ched the game. Unluckily, she was injured twice, "
				+ "though she still wanted to finish the game, her body situation did not allow her to do so. Her insistence moved "
				+ "so many audience, they gave her the biggest applause.The power of insistence is great, it will help you set free "
				+ "your potential and keep move on. Just for the players, they will face all kinds of incidences now and then, but the "
				+ "will to insist will make the中文中文m finish the game. \n\nSometimes, people win the game not because of their excellent skills, "
				+ "but their strong will. Those who can stick on to the final line will win people’s applause.What’s more, when people insist "
				+ "to finish the game, it is the respect that they show to their opponents. Their spirit deserves people’s applause. "
				+ "female player came to the semi-final, so I stayed up to watched the game. Unluckily, she was injured twice, "
				+ "though she still wanted to finish the game, her body situation did not allow her to do so. Her insistence moved "
				+ "so many audience, they gave her the biggest applause.The power of insistence is great, it w\n\nill help you set free "
				+ "your potential and keep move on. Just for the players, they will face all kinds of incidences now and then, but the "
				+ "will to insist will make the\n\nm finish the game. Sometimes, people win the game not because of their excellent skills, "
				+ "but their strong will. Those who can stick on to the final line will win people’s applause.What’s more, when people insist "
				+ "to finish the game, it is the respect that they show to their opponents. Their spirit deserves people’s applause. "
				+ "female player came to the semi-final, so I staye\n\nd up to watched the game. Unluckily, she was injured twice, "
				+ "though she still wanted to finish the game, her body situation did not allow her to do so. Her insistence moved "
				+ "so many audience, they gave her the biggest applause.The power of insistence is great, it will help you set free "
				+ "your potential and keep move on. Just for the players, they will face all kinds of incidences now and then, but the "
				+ "will to insist will make them finish the game. Sometimes, people win the game not because of their excellent skills, "
				+ "but their strong will. Those who can stick on to the final line will win people’s applause.What’s more, when people insist "
				+ "to finish the game, it is the respect that they show to their opponents. Their spirit deserves people’s applause. "
				+ "female player came to the semi-final, so I stayed up to watched the game. Unluckily, she was injured twice, "
				+ "though she still wanted to finish the game, her body situation did no\n\nt allow her to do so. Her insistence moved "
				+ "so many audience, they gave her the biggest applause.The power of insistence is great, it will help you set free "
				+ "your potential and keep move on. Just \n\nfor the players, they will face all kinds of incidences now and then, but the "
				+ "will to insist will make them finish\n\n the game. Sometimes, people win the game not because of their excellent skills, "
				+ "but their strong will. Those who can stick on to the final line will win people’s applause.What’s more, when people insist "
				+ "to finish the game, it is the respect that they show to their opponents. Their spirit deserves people’s applause. "
				+ "female player came to the semi-final, so I stayed up to watched the game. Unluckily, she was injured twice, "
				+ "though she still wanted to finish the game, her body situation did not allow her to do so. Her insistence moved "
				+ "so many audience, they gave her the biggest applause.The power of \n\ninsistence is great, it will help you set free "
				+ "your potential and keep move on. Just for the players, they will face all kinds of incidences now and then, but the "
				+ "will to insist will make t\n\nem finish the game. Sometimes, people win the game not because of their excellent skills, "
				+ "but their strong will. Those who can stick on to the final line will win people’s applause.What’s more, when people insist "
				+ "to finish the game, it is the respect that they show to their opponents. Their spirit deserves people’s applause. "
				+ "Insistence is a merit, we should keep it, no matter what we do, we must remember to insist.";
		tv1.setText(content.substring(0, 300));
		tv2.setText(content.substring(300));
	}
	
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.layout_title_menu_back:
				super.onBackPressed();
				break;
			case R.id.layout_title_menu_img:
				ArticleMenuPopWindow morePopWindow = new ArticleMenuPopWindow(this);
				morePopWindow.showPopupWindow(view);
				break;
		}
	}
}
