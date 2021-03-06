package com.example.appdemo1;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.view.Gravity;

//by jmpessoa
class CustomSpinnerArrayAdapter<T> extends ArrayAdapter<String>{

    Context ctx;
    private int mTextColor = Color.BLACK;
    private int mTexBackgroundtColor = Color.TRANSPARENT;
    private int mSelectedTextColor = Color.LTGRAY;
    private int flag = 0;
    private boolean mLastItemAsPrompt = false;
    private int mTextFontSize = 0;
    private int mTextSizeTypedValue;

    private int mTextAlignment;
    private Typeface mFontFace;
    private int mFontStyle;

    public CustomSpinnerArrayAdapter(Context context, int simpleSpinnerItem, ArrayList<String> alist) {
        super(context, simpleSpinnerItem, alist);
        ctx = context;
        mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_SP;
        mTextAlignment = Gravity.CENTER;
    }


    public void SetFontSizeUnit(int _unit) {
        switch (_unit) {
            case 0: mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_SP; break; //default
            case 1: mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_PX; break;
            case 2: mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_DIP; break;
            case 3: mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_IN; break;
            case 4: mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_MM; break;
            case 5: mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_PT; break;
            case 6: mTextSizeTypedValue = TypedValue.COMPLEX_UNIT_SP; break;
        }
    }

    public void SetTextAlignment(int _alignment) {
        mTextAlignment = _alignment;
    }

    public void SetFontAndTextTypeFace(Typeface fontFace, int fontStyle) {
        mFontFace = fontFace;
        mFontStyle = fontStyle;
    }


    //This method is used to display the dropdown popup that contains data.
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        View view = super.getView(position, convertView, parent);

        //we know that simple_spinner_item has android.R.id.text1 TextView:
        //TextView text = (TextView)view.findViewById(android.R.id.text1);

        ((TextView) view).setPadding(10, 15, 10, 15);
        ((TextView) view).setTextColor(mTextColor);

        if (mTextFontSize != 0) {

            if (mTextSizeTypedValue != TypedValue.COMPLEX_UNIT_SP)
                ((TextView) view).setTextSize(mTextSizeTypedValue, mTextFontSize);
            else
                ((TextView) view).setTextSize(mTextFontSize);
        }

        ((TextView) view).setBackgroundColor(mTexBackgroundtColor);
        ((TextView) view).setTypeface(mFontFace, mFontStyle);


        ((TextView)view).setGravity(mTextAlignment);
        //((TextView) view).setGravity(Gravity.CENTER);

        return view;
    }

    //This method is used to return the customized view at specified position in list.
    @Override
    public View getView(int pos, View cnvtView, ViewGroup prnt) {

        View view = super.getView(pos, cnvtView, prnt);

        ((TextView)view).setPadding(10, 15, 10, 15);
        ((TextView)view).setTextColor(mSelectedTextColor);
        ((TextView)view).setTypeface(mFontFace, mFontStyle);
        ((TextView)view).setGravity(mTextAlignment);

        if (mTextFontSize != 0) {

            if (mTextSizeTypedValue != TypedValue.COMPLEX_UNIT_SP)
                ((TextView) view).setTextSize(mTextSizeTypedValue, mTextFontSize);
            else
                ((TextView) view).setTextSize(mTextFontSize);
        }

        if (mLastItemAsPrompt) flag = 1;

        return view;
    }

    @Override
    public int getCount() {
        if (flag == 1)
            return super.getCount() - 1; //do not show last item
        else return super.getCount();
    }

    public void SetTextColor(int txtColor){
        mTextColor = txtColor;
    }

    public void SetBackgroundColor(int txtColor){
        mTexBackgroundtColor = txtColor;
    }

    public void SetSelectedTextColor(int txtColor){
        mSelectedTextColor = txtColor;
    }

    public void SetLastItemAsPrompt(boolean _hasPrompt) {
        mLastItemAsPrompt = _hasPrompt;
    }

    public void SetTextFontSize(int txtFontSize) {
        mTextFontSize = txtFontSize;
    }

}

/*Draft java code by "Lazarus Android Module Wizard" [6/11/2014 22:00:44]*/
/*https://github.com/jmpessoa/lazandroidmodulewizard*/
/*jVisualControl template*/

public class jSpinner extends Spinner /*dummy*/ { //please, fix what GUI object will be extended!

    private long       pascalObj = 0;    // Pascal Object
    private Controls   controls  = null; // Control Class for events

    private Context context = null;
    private ViewGroup parent  = null;         // parent view
    private ViewGroup.MarginLayoutParams lparams = null;  // layout XYWH
    private Boolean enabled  = true;           // click-touch enabled!
    private int lparamsAnchorRule[] = new int[30];
    private int countAnchorRule = 0;
    private int lparamsParentRule[] = new int[30];
    private int countParentRule = 0;

    //private int lparamH = android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
    //private int lparamW = android.view.ViewGroup.LayoutParams.MATCH_PARENT;
    private int lparamH = 100;
    private int lparamW = 100;
    private int marginLeft = 5;
    private int marginTop = 5;
    private int marginRight = 5;
    private int marginBottom = 5;
    private int lgravity = Gravity.TOP | Gravity.START;
    private float lweight = 0;

    private ArrayList<String>  mStrList;
    private CustomSpinnerArrayAdapter<String> mSpAdapter;
    private boolean mLastItemAsPrompt = false;
    private int mTextAlignment;


    //GUIDELINE: please, preferentially, init all yours params names with "_", ex: int _flag, String _hello ...
    public jSpinner(Controls _ctrls, long _Self) { //Add more others news "_xxx" params if needed!
        super(_ctrls.activity);
        context   = _ctrls.activity;
        pascalObj = _Self;
        controls  = _ctrls;

        lparams = new ViewGroup.MarginLayoutParams(lparamW, lparamH);     // W,H
        lparams.setMargins(marginLeft,marginTop,marginRight,marginBottom); // L,T,R,B

        mTextAlignment = Gravity.CENTER;

        mStrList = new ArrayList<String>();

        mSpAdapter = new CustomSpinnerArrayAdapter<String>(context, android.R.layout.simple_spinner_item, mStrList);

        mSpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        setAdapter(mSpAdapter);
        setOnItemSelectedListener(spinnerListener);
    } //end constructor

    public void jFree() {
        if (parent != null) { parent.removeView(this); }
        //free local objects...
        mStrList = null;
        mSpAdapter = null;
        lparams = null;
        setOnItemSelectedListener(null);
    }

    //implement action listener type of OnItemSelectedListener
    private OnItemSelectedListener spinnerListener =new OnItemSelectedListener() {

        @Override   
   /*.*/public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ((TextView) parent.getChildAt(0)).setGravity(mTextAlignment); //Gravity.CENTER
            String caption = mStrList.get(position).toString();
            setSelection(position);
            controls.pOnSpinnerItemSeleceted(pascalObj,position,caption);
        }

        @Override
   /*.*/public void onNothingSelected(AdapterView<?> parent) {}

    };

    private static MarginLayoutParams newLayoutParams(ViewGroup aparent, ViewGroup.MarginLayoutParams baseparams) {
        if (aparent instanceof FrameLayout) {
            return new FrameLayout.LayoutParams(baseparams);
        } else if (aparent instanceof RelativeLayout) {
            return new RelativeLayout.LayoutParams(baseparams);
        } else if (aparent instanceof LinearLayout) {
            return new LinearLayout.LayoutParams(baseparams);
        } else if (aparent == null) {
            throw new NullPointerException("Parent is null");
        } else {
            throw new IllegalArgumentException("Parent is neither FrameLayout or RelativeLayout or LinearLayout: "
                    + aparent.getClass().getName());
        }
    }

    public void SetjParent(ViewGroup _viewgroup) {
        if (parent != null) { parent.removeView(this); }
        parent = _viewgroup;
        parent.addView(this,newLayoutParams(parent,(ViewGroup.MarginLayoutParams)lparams));
        lparams = null;
        lparams = (ViewGroup.MarginLayoutParams)this.getLayoutParams();
    }

    public void SetLParamWidth(int _w) {
        lparamW = _w;
    }

    public void SetLParamHeight(int _h) {
        lparamH = _h;
    }

    public void setLGravity(int _g) {
        lgravity = _g;
    }

    public void setLWeight(float _w) {
        lweight = _w;
    }

    public void SetLeftTopRightBottomWidthHeight(int _left, int _top, int _right, int _bottom, int _w, int _h) {
        marginLeft = _left;
        marginTop = _top;
        marginRight = _right;
        marginBottom = _bottom;
        lparamH = _h;
        lparamW = _w;
    }

    public void AddLParamsAnchorRule(int _rule) {
        lparamsAnchorRule[countAnchorRule] = _rule;
        countAnchorRule = countAnchorRule + 1;
    }

    public void AddLParamsParentRule(int _rule) {
        lparamsParentRule[countParentRule] = _rule;
        countParentRule = countParentRule + 1;
    }

    public void SetLayoutAll(int _idAnchor) {
        lparams.width  = lparamW;
        lparams.height = lparamH;
        lparams.setMargins(marginLeft,marginTop,marginRight,marginBottom);

        if (lparams instanceof RelativeLayout.LayoutParams) {
            if (_idAnchor > 0) {
                for (int i = 0; i < countAnchorRule; i++) {
                    ((RelativeLayout.LayoutParams)lparams).addRule(lparamsAnchorRule[i], _idAnchor);
                }
            }
            for (int j = 0; j < countParentRule; j++) {
                ((RelativeLayout.LayoutParams)lparams).addRule(lparamsParentRule[j]);
            }
        }
        if (lparams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams)lparams).gravity = lgravity;
        }
        if (lparams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams)lparams).weight = lweight;
        }
        //
        this.setLayoutParams(lparams);
    }

    public void clearLayoutAll() {
        if (lparams instanceof RelativeLayout.LayoutParams) {
            for (int i=0; i < countAnchorRule; i++) {
                ((RelativeLayout.LayoutParams)lparams).removeRule(lparamsAnchorRule[i]);
            }
            for (int j=0; j < countParentRule; j++) {
                ((RelativeLayout.LayoutParams)lparams).removeRule(lparamsParentRule[j]);
            }
        }
        countAnchorRule = 0;
        countParentRule = 0;
    }

    public void SetId(int _id) { //wrapper method pattern ...
        this.setId(_id);
    }

    //write others [public] methods code here......
    //GUIDELINE: please, preferentially, init all yours params names with "_", ex: int _flag, String _hello ..

    public int GetSelectedItemPosition() {
        return this.getSelectedItemPosition();
    }

    public String GetSelectedItem() {
        return this.getSelectedItem().toString();
    }

    public void Add(String _item) {
        mStrList.add(_item);
        //Log.i("Spinner_Add: ",_item);
        mSpAdapter.notifyDataSetChanged();
    }

    //ELERA_04032015
    public void Clear() {
        mStrList.clear();
        mSpAdapter.notifyDataSetChanged();
    }

    public void SetSelectedTextColor(int _color) {
        mSpAdapter.SetSelectedTextColor(_color);
    }

    public void SetDropListTextColor(int _color) {
        mSpAdapter.SetTextColor(_color);
    }

    public void SetDropListBackgroundColor(int _color) {
        mSpAdapter.SetBackgroundColor(_color);
    }

    public void SetLastItemAsPrompt(boolean _hasPrompt) {
        mLastItemAsPrompt = _hasPrompt;
        mSpAdapter.SetLastItemAsPrompt(_hasPrompt);
        if (mLastItemAsPrompt) {
            if (mStrList.size() > 0) setSelection(mStrList.size()-1);
        }
    }

    public int GetSize() {
        return mStrList.size();
    }

    public void Delete(int _index) {
        if (_index < 0) mStrList.remove(0);
        else if (_index > (mStrList.size()-1)) mStrList.remove(mStrList.size()-1);
        else mStrList.remove(_index);
        mSpAdapter.notifyDataSetChanged();
    }

    public void SetSelection(int _index) {
        if (_index < 0) setSelection(0);
        else if (_index > (mStrList.size()-1)) setSelection(mStrList.size()-1);
        else setSelection(_index);
    }

    public void SetItem(int _index, String _item) {
        if (_index < 0) mStrList.set(0,_item);
        else if (_index > (mStrList.size()-1)) mStrList.set(mStrList.size()-1,_item);
        else mStrList.set(_index,_item);
        mSpAdapter.notifyDataSetChanged();
    }

    public void SetTextFontSize(int _txtFontSize) {
        mSpAdapter.SetTextFontSize(_txtFontSize);
    }
   
   /*
   public void SetChangeFontSizeByComplexUnitPixel(boolean _value) {
	   mSpAdapter.SetChangeFontSizeByComplexUnitPixel(_value);
	}
   */

    public void SetFontSizeUnit(int _unit) {
        mSpAdapter.SetFontSizeUnit(_unit);
    }

    //TTextAlignment  = (taLeft, taRight, taTop, taBottom, taCenter, taCenterHorizontal, taCenterVertical);
    public void SetTextAlignment(int _alignment) {
        mTextAlignment = android.view.Gravity.CENTER;
        switch(_alignment) {
            case 0 : mTextAlignment = android.view.Gravity.START; break;
            case 1 : mTextAlignment = android.view.Gravity.END; break;
            case 2 : mTextAlignment = android.view.Gravity.TOP; break;
            case 3 : mTextAlignment = android.view.Gravity.BOTTOM; break;
            case 4 : mTextAlignment = android.view.Gravity.CENTER; break;
            case 5 : mTextAlignment = android.view.Gravity.CENTER_HORIZONTAL; break;
            case 6 : mTextAlignment = android.view.Gravity.CENTER_VERTICAL; break;
        }
        mSpAdapter.SetTextAlignment(mTextAlignment);
    }


    public void SetFontAndTextTypeFace(int _fontFace, int _fontStyle) {
        Typeface t = null;
        switch (_fontFace) {
            case 0: t = Typeface.DEFAULT; break;
            case 1: t = Typeface.SANS_SERIF; break;
            case 2: t = Typeface.SERIF; break;
            case 3: t = Typeface.MONOSPACE; break;
        }
        mSpAdapter.SetFontAndTextTypeFace(t, _fontStyle);
    }

}  //end class

