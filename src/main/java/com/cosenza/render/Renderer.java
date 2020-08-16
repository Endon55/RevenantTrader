package com.cosenza.render;

import javafx.scene.canvas.GraphicsContext;

public interface Renderer
{

    void renderData(GraphicsContext context);
    void horizontalScaleRender(GraphicsContext context);
    void verticalScaleRender(GraphicsContext context);

}
