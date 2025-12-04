import com.amalvadkar.jaia.common.Feature;

import static com.amalvadkar.jaia.common.FeatureName.COMPACT_SOURCE_FILE_AND_INSTANCE_MAIN_METHOD;
import static com.amalvadkar.jaia.common.Version.JDK_25;

@Feature(name = COMPACT_SOURCE_FILE_AND_INSTANCE_MAIN_METHOD, version = JDK_25)
void main() {
    IO.println("Hello World");
}