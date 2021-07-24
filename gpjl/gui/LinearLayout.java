package gpjl.gui;

import java.awt.Component;
import java.awt.Rectangle;

public class LinearLayout extends Layout {

    private byte orientation;

    public LinearLayout(byte orientation) {
        super();
        if(!Orientation.isValid(orientation))
            orientation = Orientation.VERTICAL;
        this.orientation = orientation;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(byte orientation) {
        if(!Orientation.isValid(orientation))
            return;
        this.orientation = orientation;
    }

    @Override
    public void setBounds(Component parent) {
        int firstMatchingParent = -1, parentMatchers = 0, extraSpace = 0;
        boolean vertical = Orientation.isVertical(orientation);
        int pos = 0;
        for(int i = 0; i < size(); i++) {
            GComponent gComponent = get(i);

            Rectangle rectangle = new Rectangle();
            rectangle.setSize(gComponent.preferedSize);

            boolean matchesParent = false;
            if(gComponent.width == Size.MATCH_PARENT) {
                rectangle.width = parent.getWidth() - gComponent.margin.getHorizontal();
                if(!vertical) {
                    rectangle.width -= pos;
                    matchesParent = true;
                    parentMatchers++;
                    if(firstMatchingParent == -1)
                        firstMatchingParent = i;
                    else
                        extraSpace += gComponent.margin.getHorizontal();
                }
            }
            if(gComponent.height == Size.MATCH_PARENT) {
                rectangle.height = parent.getHeight() - gComponent.margin.getVertical();
                if(vertical) {
                    rectangle.height -= pos;
                    matchesParent = true;
                    parentMatchers++;
                    if(firstMatchingParent == -1)
                        firstMatchingParent = i;
                    else
                        extraSpace +=  gComponent.margin.getVertical();
                }
            }

            rectangle.x = gComponent.margin.left;
            rectangle.y = gComponent.margin.top;
            if(vertical && Orientation.isHorizontal(gComponent.gravity.orientation)) {
                if(gComponent.gravity == Gravity.END)
                    rectangle.x = parent.getWidth() - rectangle.width - gComponent.margin.right;
                else if(gComponent.gravity == Gravity.CENTER)
                    rectangle.x = (parent.getWidth() - rectangle.width) / 2;
            } else if(Orientation.isVertical(gComponent.gravity.orientation)) {
                if(gComponent.gravity == Gravity.BOTTOM)
                    rectangle.y = parent.getHeight() - rectangle.height - gComponent.margin.bottom;
                else if(gComponent.gravity == Gravity.CENTER)
                    rectangle.y = (parent.getHeight() - rectangle.height) / 2;
            }

            int trueWidth = rectangle.width, trueHeight = rectangle.height;

            if(gComponent.margin.left > rectangle.x)
                rectangle.x = gComponent.margin.left;
            int freeToLeft = parent.getWidth() - rectangle.x - rectangle.width;
            if(gComponent.margin.right > freeToLeft)
                rectangle.width -= gComponent.margin.right - freeToLeft;

            if(gComponent.margin.top > rectangle.y)
                rectangle.y = gComponent.margin.top;
            int freeToBottom = parent.getHeight() - rectangle.y - rectangle.height;
            if(gComponent.margin.bottom > freeToBottom)
                rectangle.height -= gComponent.margin.bottom - freeToBottom;
        
            if(vertical) {
                rectangle.y += pos;
                pos = rectangle.y + rectangle.height + gComponent.margin.bottom;
            } else {
                rectangle.x += pos;
                pos = rectangle.x + rectangle.width + gComponent.margin.right;
            }

            if(!matchesParent && firstMatchingParent != -1) {
                extraSpace += vertical ? trueHeight + gComponent.margin.getVertical() : trueWidth + gComponent.margin.getHorizontal();
            }

            gComponent.component.setBounds(rectangle);
            gComponent.setBounds();
        }

        if(firstMatchingParent == -1)
            return;

        GComponent firstParentMatcher = get(firstMatchingParent);
        int newMax = vertical ? firstParentMatcher.component.getHeight() : firstParentMatcher.component.getWidth();
        newMax -= extraSpace;
        newMax /= parentMatchers;

        pos = vertical ? firstParentMatcher.component.getY() : firstParentMatcher.component.getX();
        for(int i = firstMatchingParent; i < size(); i++) {
            GComponent gComponent = get(i);

            Rectangle rectangle = gComponent.component.getBounds();
            if(vertical) {
                rectangle.y = pos;
                if(gComponent.height == Size.MATCH_PARENT)
                    rectangle.height = newMax;
                pos = rectangle.y + rectangle.height + gComponent.margin.bottom;
            } else {
                rectangle.x = pos;
                if(gComponent.width == Size.MATCH_PARENT)
                    rectangle.width = newMax;
                pos = rectangle.x + rectangle.width + gComponent.margin.right;
            }
            gComponent.component.setBounds(rectangle);
            gComponent.setBounds();
        }
    }

}
