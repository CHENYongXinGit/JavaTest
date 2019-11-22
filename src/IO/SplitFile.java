package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-21 15:23
 **/
public class SplitFile {

    //源头
    private File src;
    //目的地（文件夹）
    private String destDir;
    //所有分割后的文件存储路径
    private List<String> destPaths;
    //每块大小
    private int blockSize;
    //多少块
    private int size;

    public SplitFile(String srcPath, String destDir) {
        this(srcPath,destDir,1024);
    }

    public SplitFile(String srcPath, String destDir, int blockSize) {
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destPaths = new ArrayList<>();

        //初始化
        init();
    }

    private void init(){
        //总长度
        long len = this.src.length();
        //多少块
        this.size = (int) Math.ceil(len*1.0/blockSize);
        //路径
        for (int i = 0; i < size; i++) {
            this.destPaths.add(this.destDir+"/"+i+"-"+this.src.getName());
        }
    }

    /**
     * 分割
     * 1、计算每一块的起始位置及大小
     * 2、
     */
    public void split() throws IOException {

        //总长度
        long len = src.length();
        //起初位置
        int beginPos = 0;
        //实际大小
        int actualSize = (int) (blockSize>len?len :blockSize);
        for (int i = 0; i < size; i++) {
            beginPos = i*blockSize;
            if (i==size-1){
                actualSize = (int) len;
            } else {
                actualSize = blockSize;
                len -= actualSize;
            }
            splitDetail(i,beginPos,actualSize);
        }
    }

    /**
     * 指定第i块的起始位置和实际长度
     * @param i
     * @param beginPos
     * @param actualSize
     * @throws IOException
     */
    private void splitDetail(int i, int beginPos, int actualSize) throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile(this.src,"r");
        RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i),"rw");
        //随机读取
        raf1.seek(beginPos);
        //操作（分段读取）
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=raf1.read(flush)) != -1){
            if (actualSize > len){
                raf2.write(flush,0,len);
                actualSize -= len;
            } else {
                raf2.write(flush,0,actualSize);
                break;
            }
        }
        raf2.close();
        raf1.close();
    }

    /**
     * 文件合并
     * @param destPath
     */
    public void merge(String destPath) throws IOException {
        //输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
        //输入流
        for (int i = 0; i < destPaths.size(); i++) {
            InputStream is = new BufferedInputStream(new FileInputStream(destPaths.get(i)));

            //拷贝
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len=is.read(flush)) != -1){
                os.write(flush,0,len);
            }
            os.flush();
            is.close();
        }
        os.close();
    }

    /**
     * 文件合并
     * @param destPath
     */
    public void merge2(String destPath) throws IOException {
        //输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
        Vector<InputStream> vi = new Vector<>();
        SequenceInputStream sis = null;

        //输入流
        for (int i = 0; i < destPaths.size(); i++) {
            vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
        }
        sis = new SequenceInputStream(vi.elements());
        //拷贝
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=sis.read(flush)) != -1){
            os.write(flush,0,len);
        }
        os.flush();
        sis.close();
        os.close();
    }

    public static void main(String[] args) throws IOException {
        File dir = new File("dest");
        if(!dir.exists()){
            dir.mkdirs();
        }
        SplitFile splitFile = new SplitFile("bg.jpg","dest",1024*10);
        splitFile.split();

        splitFile.merge2("merge.jpg");
    }
}
