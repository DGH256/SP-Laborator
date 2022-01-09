package com.lab.services;

public class StatisticsCommand implements Command{
    @Override
    public void execute() {

        RenderContentVisitor stats = new  RenderContentVisitor();
        DocumentManager.getInstance().getBook().accept(stats);

        CountElementsVisitor counter = new CountElementsVisitor();
        DocumentManager.getInstance().getBook().accept(counter);
        counter.showStatistics();
    }
}
