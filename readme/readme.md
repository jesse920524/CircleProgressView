# CircleProgressView需求分析

### 进度条--叠加模式
#### 基础需求
1. 可设置多个progress, 它们之间是叠加关系: progress value 更大的 进度条叠在 较小的进度条之上. 如.sample图片
2. progress可配置不同的颜色. (亦可配置相同的颜色.)
3. 可配置progress的起始角度. 所有progress都有相同的起始角度.
4. 可配置base progress的width, color, 并提供默认值
5. 中间支持显示文字, 并提供文字属性配置.
6. 支持xml自定义属性

#### 进阶需求
1. progress 动画
2. 触摸反馈: 按住某个progress, progress整体变暗, 中间文字显示value
3. 触摸反馈: 支持旋转整个CircleProgressView;




### 进度条--百分比模式
#### 基础需求

#### 进阶需求
