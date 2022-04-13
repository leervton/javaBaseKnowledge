package NormalKnowledge.Base.重新加载项目;
/*
* 复制：拷贝到idea工程（ideaProject）目录之后，删除拷贝过来的项目目录下的.iml类型文件(该文件是该项目在该工程下的配置文件)，
*       让idea工具重新装载创建(该文件和src，idea在同一个目录)
*
* 加载：然后进入idea工具工具栏进行设置:file-new-module/project from existing source 从已有资源进行加载
*
* 派发iml项目配置文件：file-project structure-Artifacts-点击“+”号-Web Application:exploded-From Module
*
* 加载项目运行所需要的库：Modules-选中需要配置的项目-Dependencies-Module SDK（配置jdk）-点击“+”号-Library（配置其他jar包）
*                       modules----右边栏scope旁边的"+"号(add)----1.JARs or directories----选中项目里lib加载的包
*                       右键点击lib文件夹唤出列表----然后点击 Add as library该方法只能对lib文件夹有作用
* */
public class 如何加载从别处拷贝过来的项目 {
}
