package com.aissue.test.docAndWater;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class TestJacobWord {
    private ActiveXComponent wrdCom = null;
    private Dispatch doc = null;
    private Dispatch activeDoc = null;
    private Dispatch docSelect = null;
    private Dispatch docs = null;
    private static TestJacobWord instance = null;
    private String docName = "";

    public static TestJacobWord getInstance() {
        if (instance == null) {
            instance = new TestJacobWord();
        }
        return instance;
    }

    private boolean initWord() {
        boolean flag = false;
        ComThread.InitSTA();
        wrdCom = new ActiveXComponent("word.Application");
        try {
            docs = wrdCom.getProperty("Documents").toDispatch();
            wrdCom.setProperty("Visible", new Variant(false));
            flag = true;
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    private void createNewDocument() {
        doc = Dispatch.call(docs, "Add").toDispatch();
        docSelect = Dispatch.get(wrdCom, "Selection").toDispatch();
    }

    private void getActiveDoc() {
        activeDoc = wrdCom.getProperty("ActiveWindow").toDispatch();
        System.out.println(activeDoc.getProgramId());
    }

    private void openDocument(String docPath) {
        if (this.doc != null) {
            closeDocument();
        }
        this.doc = Dispatch.call(docs, "Open", docPath, new Variant(false),
                new Variant(false)).toDispatch();
        docSelect = Dispatch.get(wrdCom, "Selection").toDispatch();
    }

    private void closeDocument() {
        if (doc != null) {
            Dispatch.call(doc, "Save");
            Dispatch.call(doc, "Close", new Variant(true));
            doc = null;
        }
    }

    private void setImgWaterMark(String waterMarkPath) {
        Dispatch activePan = Dispatch.get(activeDoc, "ActivePane").toDispatch();
        Dispatch view = Dispatch.get(activePan, "View").toDispatch();
        Dispatch.put(view, "SeekView", new Variant(9));
        Dispatch headfooter = Dispatch.get(docSelect, "HeaderFooter")
                .toDispatch();
// 取得图形对象
        Dispatch shapes = Dispatch.get(headfooter, "Shapes").toDispatch();
        Dispatch pic = Dispatch.call(shapes, "AddPicture", waterMarkPath)
                .toDispatch();

        Dispatch.call(pic, "Select");
        Dispatch.put(pic, "Left", new Variant(10));
        Dispatch.put(pic, "Top", new Variant(200));
        Dispatch.put(pic, "Width", new Variant(150));
        Dispatch.put(pic, "Height", new Variant(80));

        Dispatch.put(view, "SeekView", new Variant(0));
    }

    public void setTextWaterMark(String waterMarkStr) {
        Dispatch activePan = Dispatch.get(activeDoc, "ActivePane").toDispatch();
        Dispatch view = Dispatch.get(activePan, "View").toDispatch();
        Dispatch.put(view, "SeekView", new Variant(9));
        Dispatch headfooter = Dispatch.get(docSelect, "HeaderFooter")
                .toDispatch();
        Dispatch shapes = Dispatch.get(headfooter, "Shapes").toDispatch();
        Dispatch selection = Dispatch.call(shapes, "AddTextEffect",
                new Variant(9), waterMarkStr, "宋体", new Variant(1),
                new Variant(false), new Variant(false), new Variant(0),
                new Variant(0)).toDispatch();
        Dispatch.call(selection, "Select");
        Dispatch shapeRange = Dispatch.get(docSelect, "ShapeRange")
                .toDispatch();
        Dispatch.put(shapeRange, "Name", "PowerPlusWaterMarkObject1");
        Dispatch textEffect = Dispatch.get(shapeRange, "TextEffect")
                .toDispatch();
        Dispatch.put(textEffect, "NormalizedHeight", new Boolean(false));
        Dispatch line = Dispatch.get(shapeRange, "Line").toDispatch();
        Dispatch.put(line, "Visible", new Boolean(false));
        Dispatch fill = Dispatch.get(shapeRange, "Fill").toDispatch();
        Dispatch.put(fill, "Visible", new Boolean(true));
// 设置水印透明度
        Dispatch.put(fill, "Transparency", new Variant(0.5));
        Dispatch foreColor = Dispatch.get(fill, "ForeColor").toDispatch();
        Dispatch.put(foreColor, "RGB", new Variant(16711620));
        Dispatch.call(fill, "Solid");
// 设置水印旋转
        Dispatch.put(shapeRange, "Rotation", new Variant(315));
        Dispatch.put(shapeRange, "LockAspectRatio", new Boolean(true));
        Dispatch.put(shapeRange, "Height", new Variant(117.0709));
        Dispatch.put(shapeRange, "Width", new Variant(468.2835));
        Dispatch.put(shapeRange, "Left", new Variant(-999995));
        Dispatch.put(shapeRange, "Top", new Variant(-999995));
        Dispatch wrapFormat = Dispatch.get(shapeRange, "WrapFormat")
                .toDispatch();
// 是否允许交叠
        Dispatch.put(wrapFormat, "AllowOverlap", new Variant(true));
        Dispatch.put(wrapFormat, "Side", new Variant(3));
        Dispatch.put(wrapFormat, "Type", new Variant(3));
        Dispatch.put(shapeRange, "RelativeHorizontalPosition", new Variant(0));
        Dispatch.put(shapeRange, "RelativeVerticalPosition", new Variant(0));
        Dispatch.put(view, "SeekView", new Variant(0));
    }

    private void closeWord() {
// 关闭word文件
        wrdCom.invoke("Quit", new Variant[] {});
// 释放com线程
        ComThread.Release();
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    private boolean addWaterMark(String wordPath, String waterMarkPath) {
        boolean flag = false;
        try {
            if (initWord()) {
                openDocument(wordPath);
                getActiveDoc();
                setImgWaterMark(waterMarkPath);
                closeDocument();
                closeWord();
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
            closeDocument();
            closeWord();
        }
        return flag;
    }

    public static void main(String[] args) {
        TestJacobWord jacob = TestJacobWord.getInstance();
        // jacob.addWaterMark("F://test//test.doc", "F://test//ymo.jpg");
        try {
            if (jacob.initWord()) {
                jacob.openDocument("D:/my.doc");
                jacob.getActiveDoc();
                jacob.setTextWaterMark("重庆宇能科技有限公司");
                jacob.closeDocument();
                jacob.closeWord();
            }
        } catch (Exception e) {
            e.printStackTrace();
            jacob.closeDocument();
            jacob.closeWord();
        }

    }
}
