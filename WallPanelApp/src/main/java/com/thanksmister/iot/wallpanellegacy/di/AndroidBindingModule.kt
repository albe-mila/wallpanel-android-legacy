/*
 * Copyright (c) 2018 LocalBuzz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.thanksmister.iot.wallpanellegacy.di

import android.arch.lifecycle.ViewModel
import com.thanksmister.iot.wallpanellegacy.BootUpReceiver
import com.thanksmister.iot.wallpanellegacy.ui.*
import com.thanksmister.iot.wallpanellegacy.ui.activities.*
import com.thanksmister.iot.wallpanellegacy.ui.fragments.*
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class AndroidBindingModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetectionViewModel::class)
    abstract fun cameraViewModel(viewModel: DetectionViewModel): ViewModel

    @ContributesAndroidInjector
    internal abstract fun welcomeActivity(): WelcomeActivity

    @ContributesAndroidInjector
    internal abstract fun settingsActivity(): SettingsActivity

    @ContributesAndroidInjector
    internal abstract fun browserActivity(): BrowserActivity

    @ContributesAndroidInjector
    internal abstract fun browserActivityNative(): BrowserActivityNative

    @ContributesAndroidInjector
    internal abstract fun browserBrowserActivityLegacy(): BrowserActivityLegacy

    @ContributesAndroidInjector
    internal abstract fun liveCameraActivity(): LiveCameraActivity

    @ContributesAndroidInjector
    internal abstract fun bootupReceiver(): BootUpReceiver

    @ContributesAndroidInjector
    internal abstract fun baseSettingsFragment(): BaseSettingsFragment

    @ContributesAndroidInjector
    internal abstract fun settingsFragment(): SettingsFragment

    @ContributesAndroidInjector
    internal abstract fun cameraSettings(): CameraSettingsFragment

    @ContributesAndroidInjector
    internal abstract fun mqttSettings(): MqttSettingsFragment

    @ContributesAndroidInjector
    internal abstract fun httpSettings(): HttpSettingsFragment

    @ContributesAndroidInjector
    internal abstract fun motionSettings(): MotionSettingsFragment

    @ContributesAndroidInjector
    internal abstract fun faceSettings(): FaceSettingsFragment

    @ContributesAndroidInjector
    internal abstract fun qrCodeSettings(): QrCodeSettingsFragment

    @ContributesAndroidInjector
    internal abstract fun sensorsSettings(): SensorsSettingsFragment
}