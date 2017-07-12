package ir.blog.stack.smartlabel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * this class inherit form constraint layout and composed of:
 * 1- A textView as Title Message
 * 2- Another textView as Body Message
 * 3- An imageView to Show Action
 */
public class SmartLabel extends ConstraintLayout {
    private final static int ATTRS_PADDING_TITLE_DEFAULT = 10;
    private final static int ATTRS_PADDING_BODY_DEFAULT = 10;
    private final static int ATTRS_PADDING_IMAGE_DEFAULT = 10;

    private OnBodyClickListener bodyClickListener;
    private ConstraintLayout container;
    private TextView textViewTitle;
    private TextView textViewBody;
    private TypedArray attributes;
    private ImageView imageView;
    private Context context;
    private View mView;

    public SmartLabel(Context context) {
        this(context, null);
    }

    public SmartLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    public SmartLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }

    /**
     * initialize all views and set listener for them.
     * @param context
     * @param attrs
     */
    private void initialize(Context context, AttributeSet attrs) {
        this.context = context;

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = layoutInflater.inflate(R.layout.smart_label, this);

        container = (ConstraintLayout) findViewById(R.id.smart_label);

        textViewTitle = (TextView) findViewById(R.id.text_view_title);
        imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewBody.setText("");
            }
        });

        textViewBody = (TextView) findViewById(R.id.text_view_body);
        textViewBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bodyClickListener != null){
                    bodyClickListener.onBodyClick(textViewBody);
                }
            }
        });

        applyXmlAttributes(attrs);
    }

    /**
     * Get all Attributes from xml layout and apply them to components in the customView
     * @param attrs
     */
    private void applyXmlAttributes(AttributeSet attrs) {
        attributes = getContext().obtainStyledAttributes(attrs, R.styleable.SmartLabel);
        try {
            setTitle(attributes.getString(R.styleable.SmartLabel_smartLabel_textTitle));
            setBody(attributes.getString(R.styleable.SmartLabel_smartLabel_textBody));
            setImage(attributes.getDrawable(R.styleable.SmartLabel_smartLabel_image));

            setTitlePadding(attributes.getDimensionPixelSize(R.styleable.SmartLabel_smartLabel_title_padding, ATTRS_PADDING_TITLE_DEFAULT));
            setBodyPadding(attributes.getDimensionPixelSize(R.styleable.SmartLabel_smartLabel_body_padding, ATTRS_PADDING_BODY_DEFAULT));
            setImagePadding(attributes.getDimensionPixelSize(R.styleable.SmartLabel_smartLabel_image_padding, ATTRS_PADDING_IMAGE_DEFAULT));

            setTitleTextColor(attributes.getColor(R.styleable.SmartLabel_smartLabel_title_textColor, getResources().getColor(R.color.black)));
            setTitleBackGroundColor(attributes.getColor(R.styleable.SmartLabel_smartLabel_title_backGroundColor, getResources().getColor(R.color.lightGrey1)));

            setBodyTextColor(attributes.getColor(R.styleable.SmartLabel_smartLabel_body_textColor, getResources().getColor(R.color.black)));
            setBodyBackGroundColor(attributes.getColor(R.styleable.SmartLabel_smartLabel_body_backGroundColor, getResources().getColor(R.color.lightGrey3)));

            setImageTintColor(attributes.getColor(R.styleable.SmartLabel_smartLabel_image_tintColor, getResources().getColor(R.color.Red)));
            setImageBackGroundColor(attributes.getColor(R.styleable.SmartLabel_smartLabel_image_BackGroundColor, getResources().getColor(R.color.lightGrey3)));
        }finally {
            attributes.recycle();
        }
    }

    /**
     * Set Title's Text.
     * Default = R.string.smart_label_from_date_title
     * which is "title" (when device language is set to english)
     *
     * @param newTitle
     */
    private void setTitle(String newTitle) {
        String finalTitle = newTitle != null ? newTitle : getResources().getString(R.string.smart_label_title);
        textViewTitle.setText(finalTitle);
    }

    /**
     * Set Body's Text.
     * Default = R.string.smart_label_from_date_body
     * which is "body" (when device language is set to english)
     *
     * @param newBody
     */
    private void setBody(String newBody) {
        String finalBody = newBody != null ? newBody : getResources().getString(R.string.smart_label_body);
        textViewBody.setText(finalBody);
    }

    /**
     * Sets the default Image
     * @param imageId
     */
    public void setImage(Drawable imageId){
        Drawable finalImage = imageId != null ? imageId : getResources().getDrawable(R.drawable.ic_error);
        imageView.setImageDrawable(finalImage);
    }

    /**
     * Set padding for title textView
     * @param newPadding
     */
    public void setTitlePadding(int newPadding){
        textViewTitle.setPadding(newPadding, newPadding, newPadding, newPadding);
    }

    /**
     * set Padding For Body textView
     * @param newPadding
     */
    public void setBodyPadding(int newPadding){
        textViewBody.setPadding(newPadding, newPadding, newPadding, newPadding);
    }

    /**
     * set padding for imageView
     * @param newPadding
     */
    public void setImagePadding(int newPadding){
        imageView.setPadding(newPadding, newPadding, newPadding, newPadding);
    }

    /**
     * Sets the text color of the title.
     *
     * @param color
     */
    public void setTitleTextColor(int color) {
        if (textViewTitle != null) {
            textViewTitle.setTextColor(color);
        }
    }

    /**
     * Sets the backGround color of the title.
     *
     * @param color
     */
    public void setTitleBackGroundColor(int color) {
        if (textViewTitle != null) {
            textViewTitle.setBackgroundColor(color);
        }
    }

    /**
     * Sets the text color of the body.
     *
     * @param color
     */
    public void setBodyTextColor(int color) {
        if (textViewBody != null) {
            textViewBody.setTextColor(color);
        }
    }

    /**
     * Sets the backGround color of the body.
     *
     * @param color
     */
    public void setBodyBackGroundColor(int color) {
        if (textViewBody != null) {
            textViewBody.setBackgroundColor(color);
        }
    }

    /**
     * Sets the tint color of the image.
     *
     * @param color
     */
    public void setImageTintColor(int color) {
        if (imageView != null) {
            imageView.setColorFilter(color);
        }
    }

    /**
     * Sets the backGround color of the image.
     *
     * @param color
     */
    public void setImageBackGroundColor(int color) {
        if (imageView != null) {
            imageView.setBackgroundColor(color);
        }
    }

    /**
     * Define Interface for Body Listeners
     */
    public interface OnBodyClickListener {
        void onBodyClick(TextView body);
    }

    /**
     * Set body Click Listener
     * @param listener
     */
    public void setOnBodyClickListener(OnBodyClickListener listener){
        bodyClickListener = listener;
    }
}
