// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StandardChartTheme.java

package org.jfree.chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.LabelBlock;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.CombinedRangeCategoryPlot;
import org.jfree.chart.plot.CombinedRangeXYPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.FastScatterPlot;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.plot.ThermometerPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.category.BarPainter;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GradientBarPainter;
import org.jfree.chart.renderer.category.LineRenderer3D;
import org.jfree.chart.renderer.category.MinMaxCategoryRenderer;
import org.jfree.chart.renderer.category.StatisticalBarRenderer;
import org.jfree.chart.renderer.xy.GradientXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

// Referenced classes of package org.jfree.chart:
//            ChartTheme, JFreeChart

public class StandardChartTheme
    implements ChartTheme, Cloneable, PublicCloneable, Serializable
{

    public static ChartTheme createJFreeTheme()
    {
        return new StandardChartTheme("JFree");
    }

    public static ChartTheme createDarknessTheme()
    {
        StandardChartTheme theme = new StandardChartTheme("Darkness");
        theme.titlePaint = Color.white;
        theme.subtitlePaint = Color.white;
        theme.legendBackgroundPaint = Color.black;
        theme.legendItemPaint = Color.white;
        theme.chartBackgroundPaint = Color.black;
        theme.plotBackgroundPaint = Color.black;
        theme.plotOutlinePaint = Color.yellow;
        theme.baselinePaint = Color.white;
        theme.crosshairPaint = Color.red;
        theme.labelLinkPaint = Color.lightGray;
        theme.tickLabelPaint = Color.white;
        theme.axisLabelPaint = Color.white;
        theme.shadowPaint = Color.darkGray;
        theme.itemLabelPaint = Color.white;
        theme.drawingSupplier = new DefaultDrawingSupplier(new Paint[] {
            Color.decode("0xFFFF00"), Color.decode("0x0036CC"), Color.decode("0xFF0000"), Color.decode("0xFFFF7F"), Color.decode("0x6681CC"), Color.decode("0xFF7F7F"), Color.decode("0xFFFFBF"), Color.decode("0x99A6CC"), Color.decode("0xFFBFBF"), Color.decode("0xA9A938"), 
            Color.decode("0x2D4587")
        }, new Paint[] {
            Color.decode("0xFFFF00"), Color.decode("0x0036CC")
        }, new Stroke[] {
            new BasicStroke(2.0F)
        }, new Stroke[] {
            new BasicStroke(0.5F)
        }, DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE);
        theme.wallPaint = Color.darkGray;
        theme.errorIndicatorPaint = Color.lightGray;
        theme.gridBandPaint = new Color(255, 255, 255, 20);
        theme.gridBandAlternatePaint = new Color(255, 255, 255, 40);
        return theme;
    }

    public static ChartTheme createLegacyTheme()
    {
        StandardChartTheme theme = new StandardChartTheme("Legacy") {

            public void apply(JFreeChart jfreechart)
            {
            }

        }
;
        return theme;
    }

    public StandardChartTheme(String name)
    {
        gridBandPaint = SymbolAxis.DEFAULT_GRID_BAND_PAINT;
        gridBandAlternatePaint = SymbolAxis.DEFAULT_GRID_BAND_ALTERNATE_PAINT;
        if(name == null)
        {
            throw new IllegalArgumentException("Null 'name' argument.");
        } else
        {
            this.name = name;
            extraLargeFont = new Font("돋음", Font.BOLD, 20);
            largeFont = new Font("돋음", Font.BOLD, 14);
            regularFont = new Font("돋음", Font.BOLD, 12);
            smallFont = new Font("sansserif", 0, 10);
            titlePaint = Color.black;
            subtitlePaint = Color.black;
            legendBackgroundPaint = Color.white;
            legendItemPaint = Color.darkGray;
            chartBackgroundPaint = Color.white;
            drawingSupplier = new DefaultDrawingSupplier();
            plotBackgroundPaint = Color.lightGray;
            plotOutlinePaint = Color.black;
            labelLinkPaint = Color.black;
            labelLinkStyle = PieLabelLinkStyle.CUBIC_CURVE;
            axisOffset = new RectangleInsets(4D, 4D, 4D, 4D);
            domainGridlinePaint = Color.white;
            rangeGridlinePaint = Color.white;
            baselinePaint = Color.black;
            crosshairPaint = Color.blue;
            axisLabelPaint = Color.darkGray;
            tickLabelPaint = Color.darkGray;
            barPainter = new GradientBarPainter();
            xyBarPainter = new GradientXYBarPainter();
            shadowVisible = true;
            shadowPaint = Color.gray;
            itemLabelPaint = Color.black;
            thermometerPaint = Color.white;
            wallPaint = BarRenderer3D.DEFAULT_WALL_PAINT;
            errorIndicatorPaint = Color.black;
            return;
        }
    }

    public Font getExtraLargeFont()
    {
        return extraLargeFont;
    }

    public void setExtraLargeFont(Font font)
    {
        if(font == null)
        {
            throw new IllegalArgumentException("Null 'font' argument.");
        } else
        {
            extraLargeFont = font;
            return;
        }
    }

    public Font getLargeFont()
    {
        return largeFont;
    }

    public void setLargeFont(Font font)
    {
        if(font == null)
        {
            throw new IllegalArgumentException("Null 'font' argument.");
        } else
        {
            largeFont = font;
            return;
        }
    }

    public Font getRegularFont()
    {
        return regularFont;
    }

    public void setRegularFont(Font font)
    {
        if(font == null)
        {
            throw new IllegalArgumentException("Null 'font' argument.");
        } else
        {
            regularFont = font;
            return;
        }
    }

    public Font getSmallFont()
    {
        return smallFont;
    }

    public void setSmallFont(Font font)
    {
        if(font == null)
        {
            throw new IllegalArgumentException("Null 'font' argument.");
        } else
        {
            smallFont = font;
            return;
        }
    }

    public Paint getTitlePaint()
    {
        return titlePaint;
    }

    public void setTitlePaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            titlePaint = paint;
            return;
        }
    }

    public Paint getSubtitlePaint()
    {
        return subtitlePaint;
    }

    public void setSubtitlePaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            subtitlePaint = paint;
            return;
        }
    }

    public Paint getChartBackgroundPaint()
    {
        return chartBackgroundPaint;
    }

    public void setChartBackgroundPaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            chartBackgroundPaint = paint;
            return;
        }
    }

    public Paint getLegendBackgroundPaint()
    {
        return legendBackgroundPaint;
    }

    public void setLegendBackgroundPaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            legendBackgroundPaint = paint;
            return;
        }
    }

    public Paint getLegendItemPaint()
    {
        return legendItemPaint;
    }

    public void setLegendItemPaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            legendItemPaint = paint;
            return;
        }
    }

    public Paint getPlotBackgroundPaint()
    {
        return plotBackgroundPaint;
    }

    public void setPlotBackgroundPaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            plotBackgroundPaint = paint;
            return;
        }
    }

    public Paint getPlotOutlinePaint()
    {
        return plotOutlinePaint;
    }

    public void setPlotOutlinePaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            plotOutlinePaint = paint;
            return;
        }
    }

    public PieLabelLinkStyle getLabelLinkStyle()
    {
        return labelLinkStyle;
    }

    public void setLabelLinkStyle(PieLabelLinkStyle style)
    {
        if(style == null)
        {
            throw new IllegalArgumentException("Null 'style' argument.");
        } else
        {
            labelLinkStyle = style;
            return;
        }
    }

    public Paint getLabelLinkPaint()
    {
        return labelLinkPaint;
    }

    public void setLabelLinkPaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            labelLinkPaint = paint;
            return;
        }
    }

    public Paint getDomainGridlinePaint()
    {
        return domainGridlinePaint;
    }

    public void setDomainGridlinePaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            domainGridlinePaint = paint;
            return;
        }
    }

    public Paint getRangeGridlinePaint()
    {
        return rangeGridlinePaint;
    }

    public void setRangeGridlinePaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            rangeGridlinePaint = paint;
            return;
        }
    }

    public Paint getBaselinePaint()
    {
        return baselinePaint;
    }

    public void setBaselinePaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            baselinePaint = paint;
            return;
        }
    }

    public Paint getCrosshairPaint()
    {
        return crosshairPaint;
    }

    public void setCrosshairPaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            crosshairPaint = paint;
            return;
        }
    }

    public RectangleInsets getAxisOffset()
    {
        return axisOffset;
    }

    public void setAxisOffset(RectangleInsets offset)
    {
        if(offset == null)
        {
            throw new IllegalArgumentException("Null 'offset' argument.");
        } else
        {
            axisOffset = offset;
            return;
        }
    }

    public Paint getAxisLabelPaint()
    {
        return axisLabelPaint;
    }

    public void setAxisLabelPaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            axisLabelPaint = paint;
            return;
        }
    }

    public Paint getTickLabelPaint()
    {
        return tickLabelPaint;
    }

    public void setTickLabelPaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            tickLabelPaint = paint;
            return;
        }
    }

    public Paint getItemLabelPaint()
    {
        return itemLabelPaint;
    }

    public void setItemLabelPaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            itemLabelPaint = paint;
            return;
        }
    }

    public boolean isShadowVisible()
    {
        return shadowVisible;
    }

    public void setShadowVisible(boolean visible)
    {
        shadowVisible = visible;
    }

    public Paint getShadowPaint()
    {
        return shadowPaint;
    }

    public void setShadowPaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            shadowPaint = paint;
            return;
        }
    }

    public BarPainter getBarPainter()
    {
        return barPainter;
    }

    public void setBarPainter(BarPainter painter)
    {
        if(painter == null)
        {
            throw new IllegalArgumentException("Null 'painter' argument.");
        } else
        {
            barPainter = painter;
            return;
        }
    }

    public XYBarPainter getXYBarPainter()
    {
        return xyBarPainter;
    }

    public void setXYBarPainter(XYBarPainter painter)
    {
        if(painter == null)
        {
            throw new IllegalArgumentException("Null 'painter' argument.");
        } else
        {
            xyBarPainter = painter;
            return;
        }
    }

    public Paint getThermometerPaint()
    {
        return thermometerPaint;
    }

    public void setThermometerPaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            thermometerPaint = paint;
            return;
        }
    }

    public Paint getWallPaint()
    {
        return wallPaint;
    }

    public void setWallPaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            wallPaint = paint;
            return;
        }
    }

    public Paint getErrorIndicatorPaint()
    {
        return errorIndicatorPaint;
    }

    public void setErrorIndicatorPaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            errorIndicatorPaint = paint;
            return;
        }
    }

    public Paint getGridBandPaint()
    {
        return gridBandPaint;
    }

    public void setGridBandPaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            gridBandPaint = paint;
            return;
        }
    }

    public Paint getGridBandAlternatePaint()
    {
        return gridBandAlternatePaint;
    }

    public void setGridBandAlternatePaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            gridBandAlternatePaint = paint;
            return;
        }
    }

    public String getName()
    {
        return name;
    }

    public DrawingSupplier getDrawingSupplier()
    {
        DrawingSupplier result = null;
        if(drawingSupplier instanceof PublicCloneable)
        {
            PublicCloneable pc = (PublicCloneable)drawingSupplier;
            try
            {
                result = (DrawingSupplier)pc.clone();
            }
            catch(CloneNotSupportedException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void setDrawingSupplier(DrawingSupplier supplier)
    {
        if(supplier == null)
        {
            throw new IllegalArgumentException("Null 'supplier' argument.");
        } else
        {
            drawingSupplier = supplier;
            return;
        }
    }

    public void apply(JFreeChart chart)
    {
        if(chart == null)
            throw new IllegalArgumentException("Null 'chart' argument.");
        TextTitle title = chart.getTitle();
        if(title != null)
        {
            title.setFont(extraLargeFont);
            title.setPaint(titlePaint);
        }
        int subtitleCount = chart.getSubtitleCount();
        for(int i = 0; i < subtitleCount; i++)
            applyToTitle(chart.getSubtitle(i));

        chart.setBackgroundPaint(chartBackgroundPaint);
        Plot plot = chart.getPlot();
        if(plot != null)
            applyToPlot(plot);
    }

    protected void applyToTitle(Title title)
    {
        if(title instanceof TextTitle)
        {
            TextTitle tt = (TextTitle)title;
            tt.setFont(largeFont);
            tt.setPaint(subtitlePaint);
        } else
        if(title instanceof LegendTitle)
        {
            LegendTitle lt = (LegendTitle)title;
            if(lt.getBackgroundPaint() != null)
                lt.setBackgroundPaint(legendBackgroundPaint);
            lt.setItemFont(regularFont);
            lt.setItemPaint(legendItemPaint);
            if(lt.getWrapper() != null)
                applyToBlockContainer(lt.getWrapper());
        } else
        if(title instanceof PaintScaleLegend)
        {
            PaintScaleLegend psl = (PaintScaleLegend)title;
            psl.setBackgroundPaint(legendBackgroundPaint);
            ValueAxis axis = psl.getAxis();
            if(axis != null)
                applyToValueAxis(axis);
        } else
        if(title instanceof CompositeTitle)
        {
            CompositeTitle ct = (CompositeTitle)title;
            BlockContainer bc = ct.getContainer();
            java.util.List blocks = bc.getBlocks();
            Iterator iterator = blocks.iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                Block b = (Block)iterator.next();
                if(b instanceof Title)
                    applyToTitle((Title)b);
            } while(true);
        }
    }

    protected void applyToBlockContainer(BlockContainer bc)
    {
        Block b;
        for(Iterator iterator = bc.getBlocks().iterator(); iterator.hasNext(); applyToBlock(b))
            b = (Block)iterator.next();

    }

    protected void applyToBlock(Block b)
    {
        if(b instanceof Title)
            applyToTitle((Title)b);
        else
        if(b instanceof LabelBlock)
        {
            LabelBlock lb = (LabelBlock)b;
            lb.setFont(regularFont);
            lb.setPaint(legendItemPaint);
        }
    }

    protected void applyToPlot(Plot plot)
    {
        if(plot == null)
            throw new IllegalArgumentException("Null 'plot' argument.");
        if(plot.getDrawingSupplier() != null)
            plot.setDrawingSupplier(getDrawingSupplier());
        if(plot.getBackgroundPaint() != null)
            plot.setBackgroundPaint(plotBackgroundPaint);
        plot.setOutlinePaint(plotOutlinePaint);
        if(plot instanceof PiePlot)
            applyToPiePlot((PiePlot)plot);
        else
        if(plot instanceof MultiplePiePlot)
            applyToMultiplePiePlot((MultiplePiePlot)plot);
        else
        if(plot instanceof CategoryPlot)
            applyToCategoryPlot((CategoryPlot)plot);
        else
        if(plot instanceof XYPlot)
            applyToXYPlot((XYPlot)plot);
        else
        if(plot instanceof FastScatterPlot)
            applyToFastScatterPlot((FastScatterPlot)plot);
        else
        if(plot instanceof MeterPlot)
            applyToMeterPlot((MeterPlot)plot);
        else
        if(plot instanceof ThermometerPlot)
            applyToThermometerPlot((ThermometerPlot)plot);
        else
        if(plot instanceof SpiderWebPlot)
            applyToSpiderWebPlot((SpiderWebPlot)plot);
        else
        if(plot instanceof PolarPlot)
            applyToPolarPlot((PolarPlot)plot);
    }

    protected void applyToPiePlot(PiePlot plot)
    {
        plot.setLabelLinkPaint(labelLinkPaint);
        plot.setLabelLinkStyle(labelLinkStyle);
        plot.setLabelFont(regularFont);
        if(plot.getAutoPopulateSectionPaint())
            plot.clearSectionPaints(false);
        if(plot.getAutoPopulateSectionOutlinePaint())
            plot.clearSectionOutlinePaints(false);
        if(plot.getAutoPopulateSectionOutlineStroke())
            plot.clearSectionOutlineStrokes(false);
    }

    protected void applyToMultiplePiePlot(MultiplePiePlot plot)
    {
        apply(plot.getPieChart());
    }

    protected void applyToCategoryPlot(CategoryPlot plot)
    {
        plot.setAxisOffset(axisOffset);
        plot.setDomainGridlinePaint(domainGridlinePaint);
        plot.setRangeGridlinePaint(rangeGridlinePaint);
        plot.setRangeZeroBaselinePaint(baselinePaint);
        int domainAxisCount = plot.getDomainAxisCount();
        for(int i = 0; i < domainAxisCount; i++)
        {
            CategoryAxis axis = plot.getDomainAxis(i);
            if(axis != null)
                applyToCategoryAxis(axis);
        }

        int rangeAxisCount = plot.getRangeAxisCount();
        for(int i = 0; i < rangeAxisCount; i++)
        {
            ValueAxis axis = plot.getRangeAxis(i);
            if(axis != null)
                applyToValueAxis(axis);
        }

        int rendererCount = plot.getRendererCount();
        for(int i = 0; i < rendererCount; i++)
        {
            CategoryItemRenderer r = plot.getRenderer(i);
            if(r != null)
                applyToCategoryItemRenderer(r);
        }

        if(plot instanceof CombinedDomainCategoryPlot)
        {
            CombinedDomainCategoryPlot cp = (CombinedDomainCategoryPlot)plot;
            Iterator iterator = cp.getSubplots().iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                CategoryPlot subplot = (CategoryPlot)iterator.next();
                if(subplot != null)
                    applyToPlot(subplot);
            } while(true);
        }
        if(plot instanceof CombinedRangeCategoryPlot)
        {
            CombinedRangeCategoryPlot cp = (CombinedRangeCategoryPlot)plot;
            Iterator iterator = cp.getSubplots().iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                CategoryPlot subplot = (CategoryPlot)iterator.next();
                if(subplot != null)
                    applyToPlot(subplot);
            } while(true);
        }
    }

    protected void applyToXYPlot(XYPlot plot)
    {
        plot.setAxisOffset(axisOffset);
        plot.setDomainZeroBaselinePaint(baselinePaint);
        plot.setRangeZeroBaselinePaint(baselinePaint);
        plot.setDomainGridlinePaint(domainGridlinePaint);
        plot.setRangeGridlinePaint(rangeGridlinePaint);
        plot.setDomainCrosshairPaint(crosshairPaint);
        plot.setRangeCrosshairPaint(crosshairPaint);
        int domainAxisCount = plot.getDomainAxisCount();
        for(int i = 0; i < domainAxisCount; i++)
        {
            ValueAxis axis = plot.getDomainAxis(i);
            if(axis != null)
                applyToValueAxis(axis);
        }

        int rangeAxisCount = plot.getRangeAxisCount();
        for(int i = 0; i < rangeAxisCount; i++)
        {
            ValueAxis axis = plot.getRangeAxis(i);
            if(axis != null)
                applyToValueAxis(axis);
        }

        int rendererCount = plot.getRendererCount();
        for(int i = 0; i < rendererCount; i++)
        {
            XYItemRenderer r = plot.getRenderer(i);
            if(r != null)
                applyToXYItemRenderer(r);
        }

        XYAnnotation a;
        for(Iterator iter = plot.getAnnotations().iterator(); iter.hasNext(); applyToXYAnnotation(a))
            a = (XYAnnotation)iter.next();

        if(plot instanceof CombinedDomainXYPlot)
        {
            CombinedDomainXYPlot cp = (CombinedDomainXYPlot)plot;
            Iterator iterator = cp.getSubplots().iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                XYPlot subplot = (XYPlot)iterator.next();
                if(subplot != null)
                    applyToPlot(subplot);
            } while(true);
        }
        if(plot instanceof CombinedRangeXYPlot)
        {
            CombinedRangeXYPlot cp = (CombinedRangeXYPlot)plot;
            Iterator iterator = cp.getSubplots().iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                XYPlot subplot = (XYPlot)iterator.next();
                if(subplot != null)
                    applyToPlot(subplot);
            } while(true);
        }
    }

    protected void applyToFastScatterPlot(FastScatterPlot plot)
    {
        plot.setDomainGridlinePaint(domainGridlinePaint);
        plot.setRangeGridlinePaint(rangeGridlinePaint);
        ValueAxis xAxis = plot.getDomainAxis();
        if(xAxis != null)
            applyToValueAxis(xAxis);
        ValueAxis yAxis = plot.getRangeAxis();
        if(yAxis != null)
            applyToValueAxis(yAxis);
    }

    protected void applyToPolarPlot(PolarPlot plot)
    {
        plot.setAngleLabelFont(regularFont);
        plot.setAngleLabelPaint(tickLabelPaint);
        plot.setAngleGridlinePaint(domainGridlinePaint);
        plot.setRadiusGridlinePaint(rangeGridlinePaint);
        ValueAxis axis = plot.getAxis();
        if(axis != null)
            applyToValueAxis(axis);
    }

    protected void applyToSpiderWebPlot(SpiderWebPlot plot)
    {
        plot.setLabelFont(regularFont);
        plot.setLabelPaint(axisLabelPaint);
        plot.setAxisLinePaint(axisLabelPaint);
    }

    protected void applyToMeterPlot(MeterPlot plot)
    {
        plot.setDialBackgroundPaint(plotBackgroundPaint);
        plot.setValueFont(largeFont);
        plot.setValuePaint(axisLabelPaint);
        plot.setDialOutlinePaint(plotOutlinePaint);
        plot.setNeedlePaint(thermometerPaint);
        plot.setTickLabelFont(regularFont);
        plot.setTickLabelPaint(tickLabelPaint);
    }

    protected void applyToThermometerPlot(ThermometerPlot plot)
    {
        plot.setValueFont(largeFont);
        plot.setThermometerPaint(thermometerPaint);
        ValueAxis axis = plot.getRangeAxis();
        if(axis != null)
            applyToValueAxis(axis);
    }

    protected void applyToCategoryAxis(CategoryAxis axis)
    {
        axis.setLabelFont(largeFont);
        axis.setLabelPaint(axisLabelPaint);
        axis.setTickLabelFont(regularFont);
        axis.setTickLabelPaint(tickLabelPaint);
        if(axis instanceof SubCategoryAxis)
        {
            SubCategoryAxis sca = (SubCategoryAxis)axis;
            sca.setSubLabelFont(regularFont);
            sca.setSubLabelPaint(tickLabelPaint);
        }
    }

    protected void applyToValueAxis(ValueAxis axis)
    {
        axis.setLabelFont(largeFont);
        axis.setLabelPaint(axisLabelPaint);
        axis.setTickLabelFont(regularFont);
        axis.setTickLabelPaint(tickLabelPaint);
        if(axis instanceof SymbolAxis)
            applyToSymbolAxis((SymbolAxis)axis);
        if(axis instanceof PeriodAxis)
            applyToPeriodAxis((PeriodAxis)axis);
    }

    protected void applyToSymbolAxis(SymbolAxis axis)
    {
        axis.setGridBandPaint(gridBandPaint);
        axis.setGridBandAlternatePaint(gridBandAlternatePaint);
    }

    protected void applyToPeriodAxis(PeriodAxis axis)
    {
        PeriodAxisLabelInfo info[] = axis.getLabelInfo();
        for(int i = 0; i < info.length; i++)
        {
            PeriodAxisLabelInfo e = info[i];
            PeriodAxisLabelInfo n = new PeriodAxisLabelInfo(e.getPeriodClass(), e.getDateFormat(), e.getPadding(), regularFont, tickLabelPaint, e.getDrawDividers(), e.getDividerStroke(), e.getDividerPaint());
            info[i] = n;
        }

        axis.setLabelInfo(info);
    }

    protected void applyToAbstractRenderer(AbstractRenderer renderer)
    {
        if(renderer.getAutoPopulateSeriesPaint())
            renderer.clearSeriesPaints(false);
        if(renderer.getAutoPopulateSeriesStroke())
            renderer.clearSeriesStrokes(false);
    }

    protected void applyToCategoryItemRenderer(CategoryItemRenderer renderer)
    {
        if(renderer == null)
            throw new IllegalArgumentException("Null 'renderer' argument.");
        if(renderer instanceof AbstractRenderer)
            applyToAbstractRenderer((AbstractRenderer)renderer);
        renderer.setBaseItemLabelFont(regularFont);
        renderer.setBaseItemLabelPaint(itemLabelPaint);
        if(renderer instanceof BarRenderer)
        {
            BarRenderer br = (BarRenderer)renderer;
            br.setBarPainter(barPainter);
            br.setShadowVisible(shadowVisible);
            br.setShadowPaint(shadowPaint);
        }
        if(renderer instanceof BarRenderer3D)
        {
            BarRenderer3D br3d = (BarRenderer3D)renderer;
            br3d.setWallPaint(wallPaint);
        }
        if(renderer instanceof LineRenderer3D)
        {
            LineRenderer3D lr3d = (LineRenderer3D)renderer;
            lr3d.setWallPaint(wallPaint);
        }
        if(renderer instanceof StatisticalBarRenderer)
        {
            StatisticalBarRenderer sbr = (StatisticalBarRenderer)renderer;
            sbr.setErrorIndicatorPaint(errorIndicatorPaint);
        }
        if(renderer instanceof MinMaxCategoryRenderer)
        {
            MinMaxCategoryRenderer mmcr = (MinMaxCategoryRenderer)renderer;
            mmcr.setGroupPaint(errorIndicatorPaint);
        }
    }

    protected void applyToXYItemRenderer(XYItemRenderer renderer)
    {
        if(renderer == null)
            throw new IllegalArgumentException("Null 'renderer' argument.");
        if(renderer instanceof AbstractRenderer)
            applyToAbstractRenderer((AbstractRenderer)renderer);
        renderer.setBaseItemLabelFont(regularFont);
        renderer.setBaseItemLabelPaint(itemLabelPaint);
        if(renderer instanceof XYBarRenderer)
        {
            XYBarRenderer br = (XYBarRenderer)renderer;
            br.setBarPainter(xyBarPainter);
            br.setShadowVisible(shadowVisible);
        }
    }

    protected void applyToXYAnnotation(XYAnnotation annotation)
    {
        if(annotation == null)
            throw new IllegalArgumentException("Null 'annotation' argument.");
        if(annotation instanceof XYTextAnnotation)
        {
            XYTextAnnotation xyta = (XYTextAnnotation)annotation;
            xyta.setFont(smallFont);
            xyta.setPaint(itemLabelPaint);
        }
    }

    public boolean equals(Object obj)
    {
        if(obj == this)
            return true;
        if(!(obj instanceof StandardChartTheme))
            return false;
        StandardChartTheme that = (StandardChartTheme)obj;
        if(!name.equals(that.name))
            return false;
        if(!extraLargeFont.equals(that.extraLargeFont))
            return false;
        if(!largeFont.equals(that.largeFont))
            return false;
        if(!regularFont.equals(that.regularFont))
            return false;
        if(!smallFont.equals(that.smallFont))
            return false;
        if(!PaintUtilities.equal(titlePaint, that.titlePaint))
            return false;
        if(!PaintUtilities.equal(subtitlePaint, that.subtitlePaint))
            return false;
        if(!PaintUtilities.equal(chartBackgroundPaint, that.chartBackgroundPaint))
            return false;
        if(!PaintUtilities.equal(legendBackgroundPaint, that.legendBackgroundPaint))
            return false;
        if(!PaintUtilities.equal(legendItemPaint, that.legendItemPaint))
            return false;
        if(!drawingSupplier.equals(that.drawingSupplier))
            return false;
        if(!PaintUtilities.equal(plotBackgroundPaint, that.plotBackgroundPaint))
            return false;
        if(!PaintUtilities.equal(plotOutlinePaint, that.plotOutlinePaint))
            return false;
        if(!labelLinkStyle.equals(that.labelLinkStyle))
            return false;
        if(!PaintUtilities.equal(labelLinkPaint, that.labelLinkPaint))
            return false;
        if(!PaintUtilities.equal(domainGridlinePaint, that.domainGridlinePaint))
            return false;
        if(!PaintUtilities.equal(rangeGridlinePaint, that.rangeGridlinePaint))
            return false;
        if(!PaintUtilities.equal(crosshairPaint, that.crosshairPaint))
            return false;
        if(!axisOffset.equals(that.axisOffset))
            return false;
        if(!PaintUtilities.equal(axisLabelPaint, that.axisLabelPaint))
            return false;
        if(!PaintUtilities.equal(tickLabelPaint, that.tickLabelPaint))
            return false;
        if(!PaintUtilities.equal(itemLabelPaint, that.itemLabelPaint))
            return false;
        if(shadowVisible != that.shadowVisible)
            return false;
        if(!PaintUtilities.equal(shadowPaint, that.shadowPaint))
            return false;
        if(!barPainter.equals(that.barPainter))
            return false;
        if(!xyBarPainter.equals(that.xyBarPainter))
            return false;
        if(!PaintUtilities.equal(thermometerPaint, that.thermometerPaint))
            return false;
        if(!PaintUtilities.equal(wallPaint, that.wallPaint))
            return false;
        if(!PaintUtilities.equal(errorIndicatorPaint, that.errorIndicatorPaint))
            return false;
        if(!PaintUtilities.equal(gridBandPaint, that.gridBandPaint))
            return false;
        return PaintUtilities.equal(gridBandAlternatePaint, that.gridBandAlternatePaint);
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream stream)
        throws IOException
    {
        stream.defaultWriteObject();
        SerialUtilities.writePaint(titlePaint, stream);
        SerialUtilities.writePaint(subtitlePaint, stream);
        SerialUtilities.writePaint(chartBackgroundPaint, stream);
        SerialUtilities.writePaint(legendBackgroundPaint, stream);
        SerialUtilities.writePaint(legendItemPaint, stream);
        SerialUtilities.writePaint(plotBackgroundPaint, stream);
        SerialUtilities.writePaint(plotOutlinePaint, stream);
        SerialUtilities.writePaint(labelLinkPaint, stream);
        SerialUtilities.writePaint(baselinePaint, stream);
        SerialUtilities.writePaint(domainGridlinePaint, stream);
        SerialUtilities.writePaint(rangeGridlinePaint, stream);
        SerialUtilities.writePaint(crosshairPaint, stream);
        SerialUtilities.writePaint(axisLabelPaint, stream);
        SerialUtilities.writePaint(tickLabelPaint, stream);
        SerialUtilities.writePaint(itemLabelPaint, stream);
        SerialUtilities.writePaint(shadowPaint, stream);
        SerialUtilities.writePaint(thermometerPaint, stream);
        SerialUtilities.writePaint(wallPaint, stream);
        SerialUtilities.writePaint(errorIndicatorPaint, stream);
        SerialUtilities.writePaint(gridBandPaint, stream);
        SerialUtilities.writePaint(gridBandAlternatePaint, stream);
    }

    private void readObject(ObjectInputStream stream)
        throws IOException, ClassNotFoundException
    {
        stream.defaultReadObject();
        titlePaint = SerialUtilities.readPaint(stream);
        subtitlePaint = SerialUtilities.readPaint(stream);
        chartBackgroundPaint = SerialUtilities.readPaint(stream);
        legendBackgroundPaint = SerialUtilities.readPaint(stream);
        legendItemPaint = SerialUtilities.readPaint(stream);
        plotBackgroundPaint = SerialUtilities.readPaint(stream);
        plotOutlinePaint = SerialUtilities.readPaint(stream);
        labelLinkPaint = SerialUtilities.readPaint(stream);
        baselinePaint = SerialUtilities.readPaint(stream);
        domainGridlinePaint = SerialUtilities.readPaint(stream);
        rangeGridlinePaint = SerialUtilities.readPaint(stream);
        crosshairPaint = SerialUtilities.readPaint(stream);
        axisLabelPaint = SerialUtilities.readPaint(stream);
        tickLabelPaint = SerialUtilities.readPaint(stream);
        itemLabelPaint = SerialUtilities.readPaint(stream);
        shadowPaint = SerialUtilities.readPaint(stream);
        thermometerPaint = SerialUtilities.readPaint(stream);
        wallPaint = SerialUtilities.readPaint(stream);
        errorIndicatorPaint = SerialUtilities.readPaint(stream);
        gridBandPaint = SerialUtilities.readPaint(stream);
        gridBandAlternatePaint = SerialUtilities.readPaint(stream);
    }

    private String name;
    private Font extraLargeFont;
    private Font largeFont;
    private Font regularFont;
    private Font smallFont;
    private transient Paint titlePaint;
    private transient Paint subtitlePaint;
    private transient Paint chartBackgroundPaint;
    private transient Paint legendBackgroundPaint;
    private transient Paint legendItemPaint;
    private DrawingSupplier drawingSupplier;
    private transient Paint plotBackgroundPaint;
    private transient Paint plotOutlinePaint;
    private PieLabelLinkStyle labelLinkStyle;
    private transient Paint labelLinkPaint;
    private transient Paint domainGridlinePaint;
    private transient Paint rangeGridlinePaint;
    private transient Paint baselinePaint;
    private transient Paint crosshairPaint;
    private RectangleInsets axisOffset;
    private transient Paint axisLabelPaint;
    private transient Paint tickLabelPaint;
    private transient Paint itemLabelPaint;
    private boolean shadowVisible;
    private transient Paint shadowPaint;
    private BarPainter barPainter;
    private XYBarPainter xyBarPainter;
    private transient Paint thermometerPaint;
    private transient Paint wallPaint;
    private transient Paint errorIndicatorPaint;
    private transient Paint gridBandPaint;
    private transient Paint gridBandAlternatePaint;
}
