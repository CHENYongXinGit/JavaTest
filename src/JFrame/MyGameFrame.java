package JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-17 16:02
 **/
public class MyGameFrame extends Frame {

    private Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null){
            //这是游戏窗口的宽度和高度
            offScreenImage = this.createImage(500,500);
        }

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    //将背景图片与飞机图片定义为成员变量

    Image bgImg = GameUtil.getImage("images/bg.jpg");
    Image planeImg = GameUtil.getImage("images/plane.png");

    Plane plane = new Plane(planeImg,300,300,3);
    ArrayList<Shell> shellList = new ArrayList<Shell>();
    //创建爆炸对象
    Explode bao;
    //游戏起始时刻
    Date startTime = new Date();
    //游戏结束时刻
    Date endTime;

    /**
     * paint方法作用是：画出整个窗口及内部内容。被系统自动调用。
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(bgImg, 0, 0, null);
        //画出飞机本身
        plane.drawMySelf(g);
        //画出容器中所有的子弹
        for(int i=0;i<shellList.size();i++){
            Shell b =  shellList.get(i);
            b.draw(g);

            //飞机和所有炮弹对象进行矩形检测
            boolean peng = b.getRect().intersects(plane.getRect());
            if(peng){
                //飞机死掉,画面不显示
                plane.live = false;
                endTime = new Date();
                if(bao==null){
                    bao = new Explode(plane.x,plane.y);
                }
                bao.draw(g);
            }
        }

        if(!plane.live){
            if(endTime==null){
                endTime = new Date();
            }
            int period = (int)((endTime.getTime()-startTime.getTime())/1000);
            printInfo(g, "时间："+period+"秒", 50, 120, 260, Color.white);
        }
    }
    /**
     * 在窗口上打印信息
     * @param g
     * @param str
     * @param size
     */
    public void printInfo(Graphics g,String str,int size,int x,int y,Color color){
        Color c = g.getColor();
        g.setColor(color);
        Font f = new Font("宋体",Font.BOLD,size);
        g.setFont(f);
        g.drawString(str,x,y);
        g.setColor(c);
    }

    /**
     * 定义一个重画窗口的线程类，是一个内部类
     * @author 永鑫
     *
     */
    class PaintThread extends Thread {
        @Override
        public void run(){
            while(true){
                repaint();
                try {
                    Thread.sleep(40); //1s = 1000ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //定义为内部类，可以方便的使用外部类的普通属性
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);
        }
    }

    /**
     * 窗口加载
     */
    public void launchFrame(){
        //在游戏窗口打印标题
        setTitle("飞机大战炮弹");
        //窗口默认不可见，设为可见
        setVisible(true);
        //窗口大小：宽度500，高度500
        setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        //窗口左上角顶点的坐标位置
        setLocation(300, 300);

        //增加关闭窗口监听，这样用户点击右上角关闭图标，可以关闭游戏程序
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //启动重画线程
        new PaintThread().start();
        //增加键盘的监听
        addKeyListener(new KeyMonitor());
        //初始化，生成一堆炮弹
        for(int i=0;i<50;i++){
            Shell b = new Shell();
            shellList.add(b);
        }
    }

    public static void main(String[] args) {
        MyGameFrame game = new MyGameFrame();
        game.launchFrame();
    }
}
