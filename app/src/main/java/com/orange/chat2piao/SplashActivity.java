package com.orange.chat2piao;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;

public class SplashActivity extends WelcomeActivity {
    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.white)
                .page(new TitlePage(R.drawable.ic_launcher_background,
                        "Title")
                )
                .page(new BasicPage(R.drawable.ic_launcher_foreground,
                        "Header",
                        "More text.")
                        .background(R.color.red)
                )
                .page(new BasicPage(R.drawable.ic_launcher_background,
                        "Lorem ipsum",
                        "dolor sit amet.")
                        .background(R.color.green)
                )
                .swipeToDismiss(true)
                .build();
    }
}
