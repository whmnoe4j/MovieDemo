package com.zxxk.ext.bannercarousel.view.network;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;

import com.android.http.WebImageView;
import com.zxxk.ext.bannercarousel.R;
import com.zxxk.ext.bannercarousel.view.ImageIndicatorView;

import java.util.List;

/**
 * Network ImageIndicatorView, by urls
 * 
 * @author steven-pan
 * 
 */
public class NetworkImageIndicatorView extends ImageIndicatorView {

	public NetworkImageIndicatorView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public NetworkImageIndicatorView(Context context) {
		super(context);
	}

	/**
	 * 设置显示图片URL列表
	 * 
	 * @param urlList
	 *            URL列表
	 */
	public void setupLayoutByImageUrl(final List<String> urlList) {
		if (urlList == null)
			throw new NullPointerException();

		final int len = urlList.size();
		if (len > 0) {
			for (int index = 0; index < len; index++) {
				final WebImageView pageItem = new WebImageView(getContext());
				pageItem.setScaleType(ScaleType.FIT_XY);
				pageItem.setDefaultImageResId(R.mipmap.ic_launcher);
				pageItem.setImageUrl(urlList.get(index),
						NetworkApp.getImageLoader());
				addViewItem(pageItem);
			}
		}
	}

}
