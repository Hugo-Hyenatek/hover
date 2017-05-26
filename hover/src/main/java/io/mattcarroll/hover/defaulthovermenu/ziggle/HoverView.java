package io.mattcarroll.hover.defaulthovermenu.ziggle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import io.mattcarroll.hover.HoverMenuAdapter;
import io.mattcarroll.hover.R;
import io.mattcarroll.hover.defaulthovermenu.view.InViewGroupDragger;

/**
 * TODO:
 */
public class HoverView extends FrameLayout {

    private HoverMenuView2 mHoverMenuView;

    public HoverView(@NonNull Context context) {
        this(context, null);
    }

    public HoverView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        int touchDiameter = getResources().getDimensionPixelSize(R.dimen.exit_radius);
        int slop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        InViewGroupDragger dragger = new InViewGroupDragger(this, touchDiameter, slop);
        dragger.enableDebugMode(true);
        mHoverMenuView = new HoverMenuView2(getContext(), dragger);
        FrameLayout.LayoutParams layoutParams = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        addView(mHoverMenuView, layoutParams);
    }

    public void setAdapter(@Nullable HoverMenuAdapter adapter) {
        mHoverMenuView.setAdapter(adapter);
    }
}
