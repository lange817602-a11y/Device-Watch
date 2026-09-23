package org.jarsi.devicewatch.data

import android.app.admin.DevicePolicyManager
import com.google.common.truth.Truth.assertThat
import org.jarsi.devicewatch.R
import org.junit.Test

class SystemStatsRepositoryImplTest {

    @Test
    fun `storage encryption status mapping covers documented states`() {
        assertThat(storageEncryptionStatusTextRes(DevicePolicyManager.ENCRYPTION_STATUS_ACTIVE))
            .isEqualTo(R.string.security_encryption_enabled)
        assertThat(
            storageEncryptionStatusTextRes(
                status = DevicePolicyManager.ENCRYPTION_STATUS_ACTIVE_PER_USER,
                sdkInt = android.os.Build.VERSION_CODES.N,
            )
        )
            .isEqualTo(R.string.security_encryption_per_user)
        assertThat(
            storageEncryptionStatusTextRes(
                status = DevicePolicyManager.ENCRYPTION_STATUS_ACTIVE_PER_USER,
                sdkInt = android.os.Build.VERSION_CODES.M,
            )
        )
            .isEqualTo(R.string.common_unknown)
        assertThat(
            storageEncryptionStatusTextRes(
                status = DevicePolicyManager.ENCRYPTION_STATUS_ACTIVE_DEFAULT_KEY,
                sdkInt = android.os.Build.VERSION_CODES.LOLLIPOP,
            )
        )
            .isEqualTo(R.string.common_unknown)
        assertThat(
            storageEncryptionStatusTextRes(
                status = DevicePolicyManager.ENCRYPTION_STATUS_ACTIVE_DEFAULT_KEY,
                sdkInt = android.os.Build.VERSION_CODES.LOLLIPOP_MR1,
            )
        )
            .isEqualTo(R.string.security_encryption_default_key)
        assertThat(storageEncryptionStatusTextRes(DevicePolicyManager.ENCRYPTION_STATUS_INACTIVE))
            .isEqualTo(R.string.security_encryption_disabled)
        assertThat(storageEncryptionStatusTextRes(DevicePolicyManager.ENCRYPTION_STATUS_UNSUPPORTED))
            .isEqualTo(R.string.common_unsupported)
        assertThat(storageEncryptionStatusTextRes(DevicePolicyManager.ENCRYPTION_STATUS_UNKNOWN))
            .isEqualTo(R.string.common_unknown)
        assertThat(storageEncryptionStatusTextRes(Int.MIN_VALUE))
            .isEqualTo(R.string.common_unknown)
    }
}
